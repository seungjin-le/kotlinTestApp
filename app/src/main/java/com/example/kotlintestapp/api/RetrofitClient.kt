package com.example.kotlintestapp.api

import SecureStorageHelper.getString
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
  private const val BASE_URL = "https://foreat-order-api.bubaum.dev/"


  // OkHttpClient에 Interceptor 추가
  private val httpClient = OkHttpClient.Builder()
    .addInterceptor(Interceptor { chain ->
      val original = chain.request()
      val token = getString("accessToken")
      // 기본 헤더 추가

      val request = original.newBuilder()
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer $token")
        .header("Accept", "application/json").method(original.method(), original.body())


      if (!token.isNullOrEmpty()) {
        request.header("Authorization", "Bearer $token")
      }

  
      chain.proceed(request.build())
    }).build()


  // 인증 토큰을 가져오는 함수 (실제 구현은 저장소에서 가져와야 함)
  private fun getAuthToken(): String {
    // SharedPreferences나 다른 저장소에서 토큰을 가져오는 로직
    return ""  // 실제 토큰으로 교체해야 함
  }


  private val gson = GsonBuilder().setLenient().create()


  private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(httpClient)  // OkHttpClient 설정
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

  fun <T> createService(serviceClass: Class<T>): T {
    return retrofit.create(serviceClass)
  }

  // API 서비스 인스턴스 생성
  val apiService: ApiService by lazy {
    createService(ApiService::class.java)
  }
}