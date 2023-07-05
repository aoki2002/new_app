package com.example.sns_app.viewmodel

import android.media.metrics.Event
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class SignUpViewModel(private val authenticationRepository: AuthenticationRepository): ViewModel() {

    private val onTransit = MutableLiveData<Event>()

    private val _signup_name = MutableLiveData<String>().also {
        it.value = ""
    }

    val signup_name: LiveData<String>
        get() = _signup_name

    private val _signup_email = MutableLiveData<String>().also {
        it.value = ""
    }

    val signup_email: LiveData<String>
        get() = _signup_name

    private val _signup_password = MutableLiveData<String>().also {
        it.value = ""
    }

    val signup_password: LiveData<String>
        get() = _signup_name

    fun buttonTapped() {

        authenticationRepository.loginAccount(signup_email.toString(), signup_password.toString())
    }
}