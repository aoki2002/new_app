package com.example.sns_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class UserViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    fun logoutButtonTapped() {

        authenticationRepository.logoutAccount()
    }

}