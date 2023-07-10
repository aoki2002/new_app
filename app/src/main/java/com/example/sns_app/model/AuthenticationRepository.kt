package com.example.sns_app.model

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationRepository {

    private var auth = Firebase.auth
    private var checkResult: Boolean? = null
    private var loginResult: Boolean? = null
    private var createResult: Boolean? = null

    fun checkAccount(): Boolean? {

        return (auth.currentUser != null)
    }

    fun loginAccount(email: String, password: String): Boolean? {

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                loginResult = true
            }
            .addOnFailureListener {

                loginResult = false
            }

        return loginResult
    }

    fun createAccount(email: String, password: String): Boolean? {

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