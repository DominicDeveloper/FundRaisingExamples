package com.example.projectworkaprilkumak.onboarding.accaunt_setup

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentFillProfileBinding
import com.example.projectworkaprilkumak.databinding.FragmentSignUpBinding
import com.example.projectworkaprilkumak.datas.Profile
import com.example.projectworkaprilkumak.datas.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class FillProfile : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFillProfileBinding.inflate(inflater, container, false)
        binding.continueBtn.setOnClickListener { findNavController().navigate(R.id.action_fillProfile_to_selectInterestFragment) }

        var toolbar: Toolbar = binding.toolbar
        val activity : AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)


        var userList = mutableListOf<Profile>()
        var sharedPreferences = this.requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)
        var edit = sharedPreferences.edit()
        var gson = Gson()
        var type = object : TypeToken<List<Profile>>() {}.type


        var gender = binding.spinner.selectedItem.toString()


        binding.continueBtn.setOnClickListener {
            var profilers = sharedPreferences.getString("profiles", "")
            if (profilers == ""){
                userList.add(Profile(binding.profileName.text.toString(),
                    binding.profileEmail.text.toString(),
                    binding.profilePhoneNumber.text.toString(),
                    gender,
                    binding.profileCity.text.toString()))
                val str = gson.toJson(userList)
                edit.putString("profiles", str).commit()
            } else{
                userList = gson.fromJson(profilers, type)

                userList.add(Profile(binding.profileName.text.toString(), binding.profileEmail.text.toString(),
                    binding.profilePhoneNumber.text.toString(), gender, binding.profileCity.text.toString()))
                    Toast.makeText(requireContext(), "Successfully registered", Toast.LENGTH_SHORT).show()
                    val str = gson.toJson(userList)
                    edit.putString("profiles", str).commit()
                    findNavController().navigate(R.id.action_fillProfile_to_selectInterestFragment)

            }
        }


        toolbar.setNavigationOnClickListener { findNavController().navigate(R.id.action_fillProfile_to_selectCountryFragment) }




        return binding.root
    }

}