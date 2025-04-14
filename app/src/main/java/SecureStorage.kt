import android.content.Context
import android.content.SharedPreferences
import android.util.Log // Log 사용 예시
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.kotlintestapp.models.StoreSetting
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.IOException
import java.security.GeneralSecurityException

object SecureStorageHelper {

  private const val TAG = "Storage" // 로그 태그
  private const val PREFS_FILE_NAME = "secure_app_prefs"

  // SharedPreferences 인스턴스를 저장할 변수 (lazy 초기화 사용)
  // 앱 실행 중 처음 접근될 때 한 번만 초기화됨
  private var encryptedPrefs: SharedPreferences? = null

  // MasterKey 인스턴스도 미리 생성하거나 lazy 초기화 가능
  private var masterKey: MasterKey? = null

  private val gson = Gson()

  // 앱 시작 시 Application 클래스 등에서 한 번 호출
  fun init(context: Context) {
    if (encryptedPrefs == null) { // 이미 초기화되었다면 다시 하지 않음
      try {
        val appContext = context.applicationContext // applicationContext 사용

        // 1. MasterKey 생성
        masterKey = MasterKey.Builder(appContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
          .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
          .build()

        // 2. EncryptedSharedPreferences 인스턴스 생성 및 저장
        encryptedPrefs = EncryptedSharedPreferences.create(
          appContext,
          PREFS_FILE_NAME,
          masterKey!!, // masterKey가 null이 아님을 보장 (실제로는 null 체크 필요)
          EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
          EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
      } catch (e: GeneralSecurityException) {
        Log.e(TAG, "Error initializing EncryptedSharedPreferences", e)
        // 초기화 실패 시 encryptedPrefs는 null로 유지됨
      } catch (e: IOException) {
        Log.e(TAG, "Error initializing EncryptedSharedPreferences", e)
        // 초기화 실패 시 encryptedPrefs는 null로 유지됨
      }
    }
  }

  // SharedPreferences 인스턴스를 안전하게 가져오는 private 함수
  private fun getPrefs(): SharedPreferences? {
    if (encryptedPrefs == null) {
      Log.w(TAG, "SecureStorageHelper is not initialized or initialization failed.")
    }
    return encryptedPrefs
  }

  // --- 데이터 저장 함수 ---
  // 이제 context 파라미터가 필요 없음 (init에서 설정된 인스턴스 사용)

  fun saveString(key: String, value: String) {
    getPrefs()?.edit()?.putString(key, value)?.apply()
  }

  fun saveInt(key: String, value: Int) {
    getPrefs()?.edit()?.putInt(key, value)?.apply()
  }

  fun saveBoolean(key: String, value: Boolean) {
    getPrefs()?.edit()?.putBoolean(key, value)?.apply()
  }

  // --- 객체 저장 함수 ---
  fun <T> saveObject(key: String, value: T?) {
    if (value == null) {
      // null 객체는 저장하지 않거나, 키를 삭제할 수 있습니다.
      remove(key) // 예: null이면 기존 값 삭제
      return
    }
    try {
      val jsonString = gson.toJson(value) // 객체를 JSON 문자열로 변환
      saveString(key, jsonString) // 내부의 saveString 활용
    } catch (e: Exception) {
      Log.e(TAG, "Error saving object to JSON for key: $key", e)
    }
  }


  // --- 데이터 읽기 함수 ---

  fun getString(key: String, defaultValue: String? = null): String? {
    return getPrefs()?.getString(key, defaultValue)
  }

  fun getInt(key: String, defaultValue: Int = 0): Int {
    // null일 경우 defaultValue 반환 보장
    return getPrefs()?.getInt(key, defaultValue) ?: defaultValue
  }

  fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
    // null일 경우 defaultValue 반환 보장
    return getPrefs()?.getBoolean(key, defaultValue) ?: defaultValue
  }

  // --- 객체 읽기 함수 ---
  fun <T> getObject(key: String, classOfT: Class<T>): T? {
    val jsonString = getString(key, null) // 내부의 getString 활용
    if (jsonString != null) {
      try {
        return gson.fromJson(jsonString, classOfT) // JSON 문자열을 객체로 변환
      } catch (e: JsonSyntaxException) {
        // JSON 파싱 오류 처리
        Log.e(TAG, "Error parsing JSON for key: $key", e)
      } catch (e: Exception) {
        // 기타 오류 처리
        Log.e(TAG, "Error getting object for key: $key", e)
      }
    }
    return null // 키가 없거나 오류 발생 시 null 반환
  }


  fun getSettings(): StoreSetting? {
    return getObject("setting", StoreSetting::class.java)
  }


  // --- 특정 키 데이터 삭제 ---
  fun remove(key: String) {
    getPrefs()?.edit()?.remove(key)?.apply()
  }

  // --- 모든 데이터 삭제 ---
  fun clearAll() {
    getPrefs()?.edit()?.clear()?.apply()
  }
}