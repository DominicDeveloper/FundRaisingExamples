package com.example.projectworkaprilkumak.navbar

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.MainActivity
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentProfileBinding
import com.example.projectworkaprilkumak.datas.Profile
import com.example.projectworkaprilkumak.datas.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)


        var toolbar: Toolbar = binding.toolbar
        val activity : AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)

        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }


        var sharedPreferences = this.requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)
        var gson = Gson()
        var userList = mutableListOf<Profile>()
        var type = object : TypeToken<List<Profile>>() {}.type

        var users = sharedPreferences.getString("profiles", "")

         userList = gson.fromJson(users, type)
                for(i in userList){
                   binding.profileName.setText(i.fullN)
                   binding.profileEmail.setText(i.email)
                   binding.profilePhoneNumber.setText(i.phoneN)
                   binding.profileGender.setText(i.gender)
                   binding.profileCity.setText(i.city)
            }
        return binding.root
    }



}