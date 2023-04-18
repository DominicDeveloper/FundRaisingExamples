package com.example.projectworkaprilkumak.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentIntro2Binding

class Intro2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentIntro2Binding.inflate(inflater, container, false)
        binding.next.setOnClickListener {
            findNavController().navigate(R.id.action_intro2Fragment_to_intro3Fragment)
        }
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_intro2Fragment_to_welcomeFragment)
        }
        return binding.root
    }


}