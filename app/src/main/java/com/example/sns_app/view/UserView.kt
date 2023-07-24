package com.example.sns_app.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sns_app.GeneralActivity
import com.example.sns_app.MainActivity
import com.example.sns_app.R
import com.example.sns_app.databinding.FragmentUserBinding
import com.example.sns_app.viewmodel.UserViewModel

class UserView: Fragment() {

    private lateinit var binding: FragmentUserBinding

    val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)

        binding.viewModel = userViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()

        val logoutObserver = Observer<Boolean> { logout ->
            if (logout) {

                val intent = Intent(activity, GeneralActivity::class.java)

                startActivity(intent)
            } else {

                Toast.makeText(activity, "ログアウト失敗", Toast.LENGTH_LONG).show()
            }
        }

        userViewModel.logoutIsEnable.observe(this, logoutObserver)
    }
}