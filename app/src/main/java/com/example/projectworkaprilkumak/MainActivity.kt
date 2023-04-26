package com.example.projectworkaprilkumak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projectworkaprilkumak.Home.HomeFragment
import com.example.projectworkaprilkumak.actionbar.BookmarkFragment
import com.example.projectworkaprilkumak.actionbar.NotificationFragment
import com.example.projectworkaprilkumak.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = findViewById(R.id.navBar)
        navView.setupWithNavController(navController)

        binding.navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> findNavController(R.id.navHost).navigate(R.id.homeFragment)
                R.id.calendarFragment -> findNavController(R.id.navHost).navigate(R.id.calendarFragment)  //1
                R.id.myFundraisingFragment -> findNavController(R.id.navHost).navigate(R.id.myFundraisingFragment) //2
                R.id.chatFragment -> findNavController(R.id.navHost).navigate(R.id.chatFragment)//3
                R.id.profileFragment -> findNavController(R.id.navHost).navigate(R.id.profileFragment) //4
            }

            true
        }

        navController.addOnDestinationChangedListener {_, destination,_ ->
            when(destination.id) {
                R.id.homeFragment -> binding.navBar.visibility = View.VISIBLE
                R.id.chatFragment -> binding.navBar.visibility = View.VISIBLE
                R.id.profileFragment -> binding.navBar.visibility = View.VISIBLE
                R.id.calendarFragment -> binding.navBar.visibility = View.VISIBLE
                R.id.myFundraisingFragment -> binding.navBar.visibility = View.VISIBLE

                else -> binding.navBar.visibility = View.GONE
            }

        }
}

}