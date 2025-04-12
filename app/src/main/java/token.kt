import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

// 저장할 헤더의 키 정의
val AUTH_TOKEN_KEY = stringPreferencesKey("jwt")

val CUSTOM_HEADER_KEY = stringPreferencesKey("header")


// 헤더를 Preferences DataStore에 저장하는 suspend 함수
suspend fun saveJwt(context: Context, token: String) {
  context.dataStore.edit { settings -> settings[AUTH_TOKEN_KEY] = token }
}

// Preferences DataStore에서 헤더를 가져오는 suspend 함수
suspend fun getJwt(context: Context): String? {
  return context.dataStore.data.first()[AUTH_TOKEN_KEY]

}


