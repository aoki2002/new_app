package com.example.sns_app.model

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationRepository {

    private lateinit var auth: FirebaseAuth
    private var checkResult: Boolean? = null
    private var loginResult: Boolean? = null
    private var createResult: Boolean? = null

    fun checkAccount(): Boolean? {

        auth = Firebase.auth

        return (auth.currentUser != null)
    }

    fun loginAccount(email: String, password: String): Boolean? {

        auth = Firebase.auth

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

        Log.d("AuthenticationRepository", email)

        auth = Firebase.auth

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