package com.example.sns_app.model

import android.database.Observable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.os.Bundle
import android.widget.Toast

class AuthenticationManager: AuthenticationRepository {

    private var auth = Firebase.auth

    override fun checkAccount(): Boolean {

        val currentUser = auth.currentUser

        val checkIsEnable: Boolean = (currentUser != null)

        return checkIsEnable
    }

    override fun loginAccount(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {

            }
            .addOnFailureListener {

            }
    }

    override fun createAccount(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {

                val user = auth.currentUser

            }
            .addOnFailureListener {

            }
    }

}