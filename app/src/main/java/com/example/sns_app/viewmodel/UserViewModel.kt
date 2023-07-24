package com.example.sns_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository

class UserViewModel: ViewModel() {

    var logoutIsEnable = MutableLiveData<Boolean>()

    private val authenticationRepository = AuthenticationRepository()

    fun logoutButtonTapped() {

        if( authenticationRepository.logoutAccount() == true) {

            logoutIsEnable.value = true
        } else {

            logoutIsEnable.value = false
        }
    }

}