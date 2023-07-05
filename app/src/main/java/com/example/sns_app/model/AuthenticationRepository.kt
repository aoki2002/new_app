package com.example.sns_app.model

import android.database.Observable

interface AuthenticationRepository {

    fun checkAccount(): Boolean

    fun loginAccount(email: String, password: String)

    fun createAccount(email: String, password: String)
}