package com.example.projectworkaprilkumak.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentIntro1Binding

class Intro1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentIntro1Binding.inflate(inflater, container, false)
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_intro1Fragment_to_intro2Fragment)
        }
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_intro1Fragment_to_welcomeFragment)
        }
        return binding.root
    }

}