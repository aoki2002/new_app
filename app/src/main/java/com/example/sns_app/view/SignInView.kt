package com.example.sns_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentSigninBinding
import com.example.sns_app.databinding.FragmentSignupBinding
import com.example.sns_app.viewmodel.SignInViewModel
import com.example.sns_app.viewmodel.SignUpViewModel

class SignInView: Fragment() {

    private lateinit var binding: FragmentSigninBinding

    private val signupViewModel: SignInViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)

        binding.viewModel = signupViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}