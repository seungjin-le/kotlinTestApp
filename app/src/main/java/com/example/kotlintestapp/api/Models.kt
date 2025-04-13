package com.example.kotlintestapp.api

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
  @SerializedName("result_status")
  val resultStatus: String,
  @SerializedName("result_message")
  val resultMessage: String,
  @SerializedName("result_data")
  val resultData: T,
)

data class LoginRequest(
  val username: String,
  val password: String,
  val role: String,
)

data class LoginResponse(
  @SerializedName("access_token")
  val accessToken: String,
)

