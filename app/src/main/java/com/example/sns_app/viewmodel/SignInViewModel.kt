package com.example.sns_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignInViewModel {

    private val _email: MutableLiveData<String> = MutableLiveData<String>()
    private val _password: MutableLiveData<String> = MutableLiveData<String>()

    val email: LiveData<String>
        get() = _email
    val password: LiveData<String>
        get() = _password
}