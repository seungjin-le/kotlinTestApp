package com.example.kotlintestapp.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object ApiHelper {
  // 동기적 API 호출
  fun <T> executeCall(call: Call<T>): Result<T> {
    return try {
      val response = call.execute()
      if (response.isSuccessful) {
        println("response = ${response.body()} ${response.code()} ${response.message()}")
        Result.success(response.body()!!)

      } else {
        println("response = ${response.body()} ${response.code()} ${response.message()}")
        Result.failure(Exception("API 오류: ${response.code()} ${response.message()}"))
      }
    } catch (e: Exception) {
      Result.failure(e)
    }
  }

  // 비동기적 API 호출
  fun <T> enqueueCall(call: Call<T>, onSuccess: (T) -> Unit, onError: (String) -> Unit) {
    call.enqueue(object : Callback<T> {
      override fun onResponse(call: Call<T>, response: Response<T>) {
        println("response = ${response.body()} ${response.code()} ${response.message()}")
        if (response.isSuccessful) {
          response.body()?.let {
            onSuccess(it)
          } ?: onError("응답 데이터가 없습니다")
        } else {
          onError("API 오류: ${response.code()} ${response.message()}")
        }
      }

      override fun onFailure(call: Call<T>, t: Throwable) {
        onError("네트워크 오류: ${t.message}")
      }
    })
  }

  // 코루틴을 사용한 API 호출
  suspend fun <T> api(call: Call<T>): T = suspendCoroutine { continuation ->
    call.enqueue(object : Callback<T> {

      override fun onResponse(call: Call<T>, response: Response<T>) {
        println("response = ${response.body()} ${response.code()} ${response.message()}")
        if (response.isSuccessful) {
          response.body()?.let {
            continuation.resume(it)
          } ?: continuation.resumeWithException(Exception("응답 데이터가 없습니다"))
        } else {
          continuation.resumeWithException(Exception("API 오류: ${response.code()} ${response.message()}"))
        }
      }

      override fun onFailure(call: Call<T>, t: Throwable) {
        println("response = ${t}")
        continuation.resumeWithException(t)
      }
    })
  }
}