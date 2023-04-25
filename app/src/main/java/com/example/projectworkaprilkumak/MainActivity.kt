package com.example.projectworkaprilkumak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projectworkaprilkumak.Home.HomeFragment
import com.example.projectworkaprilkumak.actionbar.BookmarkFragment
import com.example.projectworkaprilkumak.actionbar.NotificationFragment
import com.example.projectworkaprilkumak.databinding.ActivityMainBinding
import com.example.projectworkaprilkumak.navbar.CalendarFragment
import com.example.projectworkaprilkumak.navbar.MyFundraisingFragment
import com.example.projectworkaprilkumak.navbar.ProfileFragment
import com.example.projectworkaprilkumak.onboarding.SplashFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)








}


}