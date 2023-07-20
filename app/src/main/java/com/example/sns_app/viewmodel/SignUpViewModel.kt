package com.example.sns_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignUpViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    var createIsEnable = MutableLiveData<Boolean>()

    val signup_name = MutableLiveData<String>()

    val signup_email = MutableLiveData<String>()

    val signup_password = MutableLiveData<String>()

    fun createButtonTapped() {

        Log.d("SignUpViewModel", signup_email.value?: "")

        if( authenticationRepository.createAccount(signup_email.value?: "", signup_password.value?: "") == true) {

            createIsEnable.value = true
        } else {
            createIsEnable.value = false
        }

    }
}