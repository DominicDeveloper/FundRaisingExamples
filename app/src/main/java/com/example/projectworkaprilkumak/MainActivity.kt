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

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)



        // yana o'sha vaziyat

        val navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHost.navController
        binding.navBar.setupWithNavController(navController)

        binding.navBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.calendarFragment -> navController.navigate(R.id.action_homeFragment_to_calendarFragment)  //1
                R.id.myFundraisingFragment -> navController.navigate(R.id.action_homeFragment_to_myFundraisingFragment) //2
                R.id.chatFragment ->navController.navigate(R.id.action_homeFragment_to_chatFragment)//3
                R.id.profileFragment -> navController.navigate(R.id.action_homeFragment_to_profileFragment) //4


                //faqat shu fragmentlarda  bo'lish kerak navbar, qolgan joylarda invisible bo'lish kk
            }
            true
        }

        lifecycleScope.launchWhenResumed {


        navController.addOnDestinationChangedListener{_, destination,_ ->
            when(destination.id) {
                R.id.homeFragment -> showBottomNavBar()
                R.id.chatFragment -> showBottomNavBar()
                R.id.profileFragment -> showBottomNavBar()
                R.id.calendarFragment -> showBottomNavBar()
                R.id.myFundraisingFragment -> showBottomNavBar() // bu fragmetnlar tori yozidimi nomi

                // ha, ishlatib koringchi,  endi chiqyapti hamma fragmentda

                // nav bar hmma frag larda chiqyapti +++ ishlamaypti, splashFragmentda chiqdimi, ha

                // yana o'sha-o'sha, hamma fragmentda boru, lekin ham ishlamayapti
                else -> hideBottomNavBar()
            }
        }
        }
        // qaniydi)), uydagilar chaqirib qolishgandi,
// comentga olingda osha codni



// qanqa chiqayabdi ui, hamma fragmentni tagida bottom nav bar bor, codiz git da bormi
        //ha, linkinibering ozimni kompimda ishlatib koray, sizda moslashaolmayabman
        //ok hozir, bo'ldimi ochidimi, nima ? github tashladim sizga ssilkasini, aha


}

    fun showBottomNavBar() {
        binding.navBar.visibility = View.VISIBLE
    }

    fun hideBottomNavBar() {
        binding.navBar.visibility = View.GONE
    }

}