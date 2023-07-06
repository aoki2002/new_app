package com.example.sns_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignUpViewModel(private val authenticationRepository: AuthenticationRepository): ViewModel() {

    var createIsEnable: Boolean? = null

    private val _signup_name = MutableLiveData<String>().also {
        it.value = ""
    }

    val signup_name: LiveData<String>
        get() = _signup_name

    private val _signup_email = MutableLiveData<String>().also {
        it.value = ""
    }

    val signup_email: LiveData<String>
        get() = _signup_email

    private val _signup_password = MutableLiveData<String>().also {
        it.value = ""
    }

    val signup_password: LiveData<String>
        get() = _signup_password

    fun createButtonTapped() {

        createIsEnable = authenticationRepository.loginAccount(_signup_email.toString(), _signup_password.toString())
    }
}