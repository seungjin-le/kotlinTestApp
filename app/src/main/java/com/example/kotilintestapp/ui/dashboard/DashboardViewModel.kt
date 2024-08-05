package com.example.kotilintestapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply { value = "대시보드 페이지" }

    val text: LiveData<String> = _text
}
