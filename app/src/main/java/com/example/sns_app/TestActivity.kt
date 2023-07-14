package com.example.sns_app

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TestActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        auth = Firebase.auth

        val button = findViewById<Button>(R.id.signup_btn1)

        button.setOnClickListener {

            val email = findViewById<EditText>(R.id.signup_edit2)
            val password = findViewById<EditText>(R.id.signup_edit3)

            auth.createUserWithEmailAndPassword(email.toString(), password.toString())
                .addOnSuccessListener {
                    Toast.makeText(this, "サインアップ成功", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"サインアップ失敗", Toast.LENGTH_LONG).show()
                }
        }
    }
}