package com.example.sns_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_app.model.AuthenticationRepository
import android.app.usage.UsageEvents.Event

class StartViewModel(private val authenticationRepository: AuthenticationRepository): ViewModel() {

    private val toMainView = MutableLiveData<Event>()

    private val toSignInView = MutableLiveData<Event>()

    fun check() {
        val checkIsEnable = authenticationRepository.checkAccount()

        if (checkIsEnable) {
            toMainView.value = Event()
        }
    }
}