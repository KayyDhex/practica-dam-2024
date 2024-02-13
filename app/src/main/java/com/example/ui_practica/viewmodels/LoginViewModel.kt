package com.example.ui_practica.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {


    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    fun onChange(it: String) {
        _email.value = it
    }

}