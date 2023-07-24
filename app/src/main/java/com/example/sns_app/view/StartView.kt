package com.example.sns_app.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sns_app.MainActivity
import com.example.sns_app.databinding.FragmentStartBinding
import com.example.sns_app.viewmodel.StartViewModel
import com.example.sns_app.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class StartView: Fragment() {

    private lateinit var binding: FragmentStartBinding

    private val startViewModel: StartViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        binding.viewModel = startViewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()

        Log.d("StartView", "スタート画面")

        startViewModel.check()

        Handler()
            .postDelayed (
                {
                    if ( startViewModel.checkIsEnable == true) {

                        val intent = Intent(activity, MainActivity::class.java)

                        startActivity(intent)
                    } else {

                        navController.navigate(R.id.action_StartFragment_to_SignInFragment)
                    }
                }
                , 3000
            )
    }
}