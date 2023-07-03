package com.example.sns_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentSignupBinding
import com.example.sns_app.viewmodel.SignUpViewModel

class SignUpView: Fragment() {

    private val signupViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentSignupBinding>(inflater, R.layout.fragment_signup, container, false)

        binding.viewModel = signupViewModel

        return binding.root

    }

}