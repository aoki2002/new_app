package com.example.sns_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignInViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    var loginIsEnable = MutableLiveData<Boolean>()

    val signin_email = MutableLiveData<String>()

    val signin_password = MutableLiveData<String>()

    fun loginButtonTapped() {

        if( authenticationRepository.loginAccount(signin_email.value?: "", signin_password.value?: "") == true) {

            loginIsEnable.value = true
        } else {

            loginIsEnable.value = false
        }
    }
}