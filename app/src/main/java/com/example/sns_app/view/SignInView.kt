package com.example.sns_app.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentSigninBinding
import com.example.sns_app.viewmodel.SignInViewModel
import androidx.lifecycle.Observer
import com.example.sns_app.MainActivity

class SignInView: Fragment() {

    private lateinit var binding: FragmentSigninBinding

    val signinViewModel: SignInViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)

        binding.viewModel = signinViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()

        val loginObserver = Observer<Boolean> { login ->
            if (login) {

                val intent = Intent(activity, MainActivity::class.java)

                startActivity(intent)
            } else {

                Toast.makeText(activity, "ログイン失敗", Toast.LENGTH_LONG).show()
            }
        }

        signinViewModel.loginIsEnable.observe(this, loginObserver)

        binding.loginBtn2.setOnClickListener {

            Log.d("SignInView", "新規登録ボタンクリック")
            navController.navigate(R.id.action_SignInFragment_to_SignUpFragment)
        }

    }

}