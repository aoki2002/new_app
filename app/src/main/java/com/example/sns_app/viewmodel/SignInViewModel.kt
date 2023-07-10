package com.example.sns_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignInViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    var loginIsEnable: Boolean? = null

    val signin_email = MutableLiveData<String>()

    val signup_password = MutableLiveData<String>()

    fun loginButtonTapped() {

        loginIsEnable = authenticationRepository.loginAccount(signin_email.toString(), signup_password.toString())
    }
}