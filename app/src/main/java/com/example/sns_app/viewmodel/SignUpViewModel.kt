package com.example.sns_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignUpViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    var createIsEnable: Boolean? = null

    val signup_name = MutableLiveData<String>()

    val signup_email = MutableLiveData<String>()

    val signup_password = MutableLiveData<String>()

    fun createButtonTapped() {

        createIsEnable = authenticationRepository.loginAccount(signup_email.toString(), signup_password.toString())
    }
}