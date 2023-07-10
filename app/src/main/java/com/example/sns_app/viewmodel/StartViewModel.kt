package com.example.sns_app.viewmodel

import androidx.lifecycle.ViewModel
import android.util.Log
import com.example.sns_app.model.AuthenticationRepository

class StartViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    var checkIsEnable: Boolean? = null

    fun check() {

        Log.d("StartViewModel", "check関数呼び出し")

        checkIsEnable = authenticationRepository.checkAccount()
    }
}