package com.example.projectworkaprilkumak.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.sharedPreferences.MySharedPreferences


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//
//        val file = MySharedPreferences.getInstance(requireActivity())
//        val status:Boolean = file.getStatus()


        val getSharedPreferences = this.requireActivity().getSharedPreferences("context", Context.MODE_PRIVATE)
        val state = getSharedPreferences.getBoolean("state", false)
        if (!state){
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_intro1Fragment)
            }, 3000)
        } else{
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
            }, 3000)
        }

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}





