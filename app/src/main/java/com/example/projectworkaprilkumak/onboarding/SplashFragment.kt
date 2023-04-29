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
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentSplashBinding
import com.example.projectworkaprilkumak.sharedPreferences.MySharedPreferences
import com.google.android.material.bottomnavigation.BottomNavigationView


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//
//        val file = MySharedPreferences.getInstance(requireActivity())
//        val status:Boolean = file.getStatus()




        val binding = FragmentSplashBinding.inflate(inflater, container, false)
        var animation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.logo_anim)
        binding.logo.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_anim)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                check()
            }
            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.loadingIcon.startAnimation(animation)

        return binding.root
    }

    fun check(){
        val getSharedPreferences = this.requireActivity().getSharedPreferences("context", Context.MODE_PRIVATE)
        val state = getSharedPreferences.getBoolean("state", false)
        if (!state){
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }, 3000)
        } else{
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
            }, 3000)
        }
    }

}





