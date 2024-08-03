package com.example.kotilintestapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProFileViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply { value = "프로필 페이지11" }
    val text: LiveData<String> = _text
}
