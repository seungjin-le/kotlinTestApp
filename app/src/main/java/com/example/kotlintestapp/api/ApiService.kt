package com.example.kotlintestapp.api

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
  // GET 요청 예시
  @GET("users/{userId}")
  fun getUser(@Path("userId") userId: String): Call<ApiResponse<Any>>


  @POST("api/v1/members/login")
  fun login(@Body loginRequest: LoginRequest): Call<ApiResponse<LoginResponse>>

  // PUT 요청 예시
  @PUT("users/{userId}")
  fun updateUser(@Path("userId") userId: String, @Body userRequest: Any): Call<ApiResponse<Any>>

  // DELETE 요청 예시
  @DELETE("users/{userId}")
  fun deleteUser(@Path("userId") userId: String): Call<Void>

  // 쿼리 파라미터 예시
  @GET("search")
  fun search(@Query("query") query: String, @Query("page") page: Int): Call<ApiResponse<Any>>
}