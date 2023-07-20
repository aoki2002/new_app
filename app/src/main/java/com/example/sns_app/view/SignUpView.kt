package com.example.sns_app.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentSignupBinding
import com.example.sns_app.viewmodel.SignUpViewModel

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

        Log.d("SignUpView", "新規登録画面表示")

        val navController = view.findNavController()

        val signupObserver = Observer<Boolean> { signup ->
            if (signup) {

                navController.navigate(R.id.action_SignUpFragment_to_MainFragment)
            } else {

                Log.d("SignUpView", "新規登録失敗")
            }
        }

        signupViewModel.createIsEnable.observe(this, signupObserver)
    }
}