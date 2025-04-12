import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.io.IOException
import java.security.GeneralSecurityException

object SecureStorageHelper {

  private const val PREFS_FILE_NAME = "secure_app_prefs" // 암호화된 SharedPreferences 파일 이름

  // EncryptedSharedPreferences 인스턴스를 생성하고 반환하는 함수
  private fun createEncryptedSharedPreferences(context: Context): SharedPreferences? {
    try {
      // 1. MasterKey 생성: 암호화 키를 안전하게 관리
      val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM) // 키 암호화 방식 설정
        .build()

      // 2. EncryptedSharedPreferences 인스턴스 생성
      return EncryptedSharedPreferences.create(
        context,
        PREFS_FILE_NAME, // 저장될 파일 이름
        masterKey, // 마스터 키
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, // 키를 암호화하는 방식
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM  // 값을 암호화하는 방식
      )
    } catch (e: GeneralSecurityException) {
      // 보안 관련 예외 처리 (키 생성 실패 등)
      println("Error creating EncryptedSharedPreferences: ${e.message}")
      // e.printStackTrace() // 디버깅 시 스택 트레이스 출력
      return null
    } catch (e: IOException) {
      // IO 관련 예외 처리 (파일 생성 실패 등)
      println("Error creating EncryptedSharedPreferences: ${e.message}")
      // e.printStackTrace() // 디버깅 시 스택 트레이스 출력
      return null
    }
  }

  // --- 데이터 저장 함수 ---

  fun saveString(context: Context, key: String, value: String) {
    
    val prefs = createEncryptedSharedPreferences(context)
    prefs?.edit()?.putString(key, value)?.apply()
  }

  fun saveInt(context: Context, key: String, value: Int) {
    val prefs = createEncryptedSharedPreferences(context)
    prefs?.edit()?.putInt(key, value)?.apply()
  }

  fun saveBoolean(context: Context, key: String, value: Boolean) {
    val prefs = createEncryptedSharedPreferences(context)
    prefs?.edit()?.putBoolean(key, value)?.apply()
  }

  // --- 데이터 읽기 함수 ---

  fun getString(context: Context, key: String, defaultValue: String? = null): String? {
    val prefs = createEncryptedSharedPreferences(context)
    return prefs?.getString(key, defaultValue)
  }

  fun getInt(context: Context, key: String, defaultValue: Int = 0): Int {
    val prefs = createEncryptedSharedPreferences(context)
    // SharedPreferences.getInt는 null을 반환하지 않으므로 defaultValue 보장됨
    return prefs?.getInt(key, defaultValue) ?: defaultValue
  }

  fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean {
    val prefs = createEncryptedSharedPreferences(context)
    // SharedPreferences.getBoolean은 null을 반환하지 않으므로 defaultValue 보장됨
    return prefs?.getBoolean(key, defaultValue) ?: defaultValue
  }

  // --- 특정 키 데이터 삭제 ---
  fun remove(context: Context, key: String) {
    val prefs = createEncryptedSharedPreferences(context)
    prefs?.edit()?.remove(key)?.apply()
  }

  // --- 모든 데이터 삭제 ---
  fun clearAll(context: Context) {
    val prefs = createEncryptedSharedPreferences(context)
    prefs?.edit()?.clear()?.apply()
  }
}