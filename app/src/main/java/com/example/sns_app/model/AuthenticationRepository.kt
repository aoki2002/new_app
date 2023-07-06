package com.example.sns_app.model

import android.database.Observable

interface AuthenticationRepository {

    fun checkAccount(): Boolean

    fun loginAccount(email: String, password: String): Boolean?

    fun createAccount(email: String, password: String): Boolean?
}