package com.example.projectworkaprilkumak.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.signinPassword.setOnClickListener { findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment) }
        binding.signupTv.setOnClickListener { findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment) }

        return binding.root
    }

}