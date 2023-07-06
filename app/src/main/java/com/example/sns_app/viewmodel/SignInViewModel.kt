package com.example.sns_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignInViewModel(private val authenticationRepository: AuthenticationRepository): ViewModel() {

    var loginIsEnable: Boolean? = null

    private val _signin_email = MutableLiveData<String>()

    val signin_email: LiveData<String>
        get() = _signin_email

    private val _signup_password = MutableLiveData<String>()

    val signup_password: LiveData<String>
        get() = _signup_password

    fun loginButtonTapped() {

        loginIsEnable = authenticationRepository.loginAccount(_signin_email.toString(), _signup_password.toString())
    }
}