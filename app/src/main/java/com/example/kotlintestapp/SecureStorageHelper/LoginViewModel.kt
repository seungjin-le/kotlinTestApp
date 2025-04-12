import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintestapp.api.ApiHelper
import com.example.kotlintestapp.api.LoginRequest
import com.example.kotlintestapp.api.RetrofitClient
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

// AndroidViewModel을 상속받아 Application Context 사용
class LoginViewModel(application: Application) : AndroidViewModel(application) {

  // Application Context 가져오기
  private val appContext = getApplication<Application>().applicationContext

  // 로그인 성공 시 내비게이션을 위한 이벤트 Flow
  private val _navigateToHome = MutableSharedFlow<Unit>()
  val navigateToHome = _navigateToHome.asSharedFlow()

  // 로그인 상태 (로딩, 에러 등)을 위한 StateFlow 등을 추가할 수 있음
  // val isLoading = MutableStateFlow(false)
  // val errorMessage = MutableStateFlow<String?>(null)

  // 예시 키
  private val KEY_AUTH_TOKEN = "accessToken"


  fun login(form: LoginRequest) {
    // isLoading.value = true // 로딩 시작
    // errorMessage.value = null // 에러 메시지 초기화

    viewModelScope.launch {
      try {
        // --- 여기에서 실제 로그인 API 호출 ---

        ApiHelper.enqueueCall(
          RetrofitClient.apiService.login(form),
          onSuccess = {

            val accessToken = it.resultData.accessToken


            if (accessToken != null) SecureStorageHelper.saveString(appContext, KEY_AUTH_TOKEN, accessToken)
            println("result success ====== ${accessToken}")
          },
          onError = {
            println("result error ====== $it")

          })


      } catch (e: Exception) {
        // 네트워크 오류 등 예외 처리

        println("로그인 중 오류 발생: ${e.message}")
      } finally {
        // isLoading.value = false // 로딩 종료
      }
    }
  }


}