package com.example.sns_app.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.sns_app.databinding.FragmentStartBinding
import com.example.sns_app.viewmodel.StartViewModel
import com.example.sns_app.R

class StartView: Fragment() {

    private lateinit var binding: FragmentStartBinding

    val startViewModel: StartViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentStartBinding.inflate(inflater, container, false)

        binding.viewModel = startViewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()

        Log.d("StartView", " aaaaaaaaaaa")

        startViewModel.check()

        Handler()
            .postDelayed (
                {
                    if ( startViewModel.checkIsEnable == true) {

                        navController.navigate(R.id.action_StartFragment_to_MainFragment)
                    } else {

                        navController.navigate(R.id.action_StartFragment_to_SignInFragment)
                    }
                }, 3000)
    }
}