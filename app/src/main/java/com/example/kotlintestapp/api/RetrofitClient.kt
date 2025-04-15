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
        .header("Accept", "application/json").method(original.method, original.body)


      if (!token.isNullOrEmpty()) {
        
        request.header("Authorization", "Bearer $token")
      }


      chain.proceed(request.build())
    }).build()


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