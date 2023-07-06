package com.example.sns_app.model

import android.database.Observable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.os.Bundle
import android.widget.Toast

class AuthenticationManager: AuthenticationRepository {

    private var auth = Firebase.auth
    private val currentUser = auth.currentUser
    private var loginResult: Boolean? = null
    private var createResult: Boolean? = null

    override fun checkAccount(): Boolean {

        return (currentUser != null)
    }

    override fun loginAccount(email: String, password: String): Boolean? {

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                loginResult = true
            }
            .addOnFailureListener {

                loginResult = false
            }

        return loginResult
    }

    override fun createAccount(email: String, password: String): Boolean? {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                createResult = true
            }
            .addOnFailureListener {

                createResult = false
            }

        return createResult
    }

}