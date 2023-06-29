package com.example.sns_app.model

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.os.Bundle

class AuthenticationManager: AuthenticationRepository {

    private lateinit var auth: FirebaseAuth

    override fun start() {

        auth = Firebase.auth

    }

    override fun checkAccount() {

        val currentUser = auth.currentUser

        if (currentUser != null) {

        } else {

        }
    }

    override fun loginAccount() {

    }

    override fun createAccount() {

    }

}