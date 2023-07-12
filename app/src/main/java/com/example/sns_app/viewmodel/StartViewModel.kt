package com.example.sns_app.viewmodel

import androidx.lifecycle.ViewModel
import android.util.Log
import com.example.sns_app.model.AuthenticationRepository
import com.google.firebase.auth.FirebaseAuth

class StartViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    var checkIsEnable: Boolean? = null

    fun check() {

        checkIsEnable = authenticationRepository.checkAccount()
    }
}