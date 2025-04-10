package com.example.kotlintestapp.api


data class ApiResponse(
  val resultStatus: String,
  val resultMessage: String,
  val resultData: Any,

  )

data class LoginRequest(
  val username: String,
  val password: String,
  val role: String
)