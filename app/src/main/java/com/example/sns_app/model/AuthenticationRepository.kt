package com.example.sns_app.model

interface AuthenticationRepository {

    fun start()

    fun checkAccount()

    fun loginAccount()

    fun createAccount()
}