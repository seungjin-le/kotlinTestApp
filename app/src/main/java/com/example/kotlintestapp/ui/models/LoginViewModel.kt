import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class LoginRequest(val email: String, val password: String)
class LoginResponse(
  val status: String,
  val message: String,
  val data: LoginData
)

data class LoginData(
  val accessToken: String,
  val refreshToken: String
)

interface RetrofitService {
  @POST("auth/login")
   fun postLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>
}



class LoginViewModel : ViewModel() {
  private val retrofit = Retrofit.Builder()
    .baseUrl("http://222.100.172.236:3000/api/v1/")
    .addConverterFactory(GsonConverterFactory.create()).build()
    .create(RetrofitService::class.java)

  private val _loginResult = MutableStateFlow<Result<LoginResponse>>(runCatching { LoginResponse("", "", LoginData("", "")) })
  val loginResult: StateFlow<Result<LoginResponse>> = _loginResult.asStateFlow()

  fun login(username: String, password: String) {
    viewModelScope.launch {
      try {
        retrofit.postLogin(LoginRequest(username, password)).enqueue(object : Callback<LoginResponse> {
          override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            if (response.isSuccessful) {
              _loginResult.value = Result.success(response.body()!!)
            } else {
              _loginResult.value = Result.failure(Exception("Login failed: ${response.code()}"))
            }
          }
          override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            _loginResult.value = Result.failure(t)
          }
        })
      } catch (e: Exception) {
        _loginResult.value = Result.failure(e)
      }
    }
  }
}