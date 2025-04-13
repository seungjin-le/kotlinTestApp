package com.example.kotlintestapp.api

import com.example.kotlintestapp.models.ChildCategory
import com.example.kotlintestapp.models.FirstCategory
import com.example.kotlintestapp.models.StoreSetting
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
  // 웨이팅 설정
  @GET("api/v1/waiting?store_id=67bfcb551c2bf321c1a107df")
  fun getWaiting(): Call<ApiResponse<StoreSetting>>
//@Path("userId") userId: String


  // 로그인
  @POST("api/v1/members/login")
  fun login(@Body loginRequest: LoginRequest): Call<ApiResponse<LoginResponse>>

  // 1차 카테고리
  @GET("api/v1/category/parent")
  fun getFirstCategory(@Query("store_id") parentCategoryId: String = "67bfcb551c2bf321c1a107df"): Call<ApiResponse<List<FirstCategory>>>

  // 2차 카테고리
  @GET("api/v1/category/child")
  fun getChildCategory(
    @Query("store_id") storeId: String? = null,
    @Query("parent_category_id") parentCategoryId: String? = null
  ): Call<ApiResponse<List<ChildCategory>>>

  // 메뉴 리스트
  @GET("api/v1/menu?store_id=67bfcb551c2bf321c1a107df")
  fun getMenuList(): Call<ApiResponse<List<ChildCategory>>>


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