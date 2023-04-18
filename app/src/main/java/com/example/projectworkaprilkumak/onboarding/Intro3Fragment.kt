package com.example.projectworkaprilkumak.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentIntro2Binding
import com.example.projectworkaprilkumak.databinding.FragmentIntro3Binding

class Intro3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentIntro3Binding.inflate(inflater, container, false)
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_intro3Fragment_to_welcomeFragment)
        }
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_intro3Fragment_to_welcomeFragment)
        }
        return binding.root
    }

}