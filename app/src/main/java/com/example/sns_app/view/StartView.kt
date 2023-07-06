package com.example.sns_app.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentStartBinding
import com.example.sns_app.viewmodel.StartViewModel

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

        startViewModel.check()

        Handler()
            .postDelayed (
                {
                    if ( startViewModel.checkIsEnable == true) {

                        navController.navigate(R.id.action_StartFragment_to_MainFragment)
                    } else {

                        navController.navigate(R.id.action_StartFragment_to_LoginFragment)
                    }
                }, 3000)
    }
}