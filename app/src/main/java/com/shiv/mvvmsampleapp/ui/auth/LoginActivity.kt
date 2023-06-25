package com.shiv.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.shiv.mvvmsampleapp.R
import com.shiv.mvvmsampleapp.databinding.ActivityLoginBinding
import com.shiv.mvvmsampleapp.util.showToast

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        showToast("Login Started")
    }

    override fun onSuccess() {
        showToast("Login Success")
    }

    override fun onError(message: String) {
        showToast(message)
    }
}