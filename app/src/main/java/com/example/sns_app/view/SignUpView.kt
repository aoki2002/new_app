package com.example.sns_app.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.sns_app.MainActivity
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentSignupBinding
import com.example.sns_app.viewmodel.SignUpViewModel
import com.google.common.base.MoreObjects.ToStringHelper

class SignUpView: Fragment() {

    private lateinit var binding: FragmentSignupBinding

    val signupViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        binding.viewModel = signupViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()

        val createObserver = Observer<Boolean> { create ->
            if (create) {

                val intent = Intent(activity, MainActivity::class.java)

                startActivity(intent)
            } else {

                Log.d("SignUpView", "新規登録失敗")

                Toast.makeText(activity, "新規登録失敗", Toast.LENGTH_LONG).show()
            }
        }

        signupViewModel.createIsEnable.observe(this, createObserver)
    }
}