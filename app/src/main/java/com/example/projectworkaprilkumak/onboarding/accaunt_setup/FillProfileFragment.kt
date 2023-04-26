package com.example.projectworkaprilkumak.onboarding.accaunt_setup

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

    private lateinit var gender:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFillProfileBinding.inflate(inflater, container, false)

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

        var list = listOf("male", "female")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_dropdown, list)
        binding.dropDownValue.setAdapter(adapter)
        binding.dropDownValue.setOnItemClickListener { adapterView, view, i, l ->
            gender = list[i]
        }

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


        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }




        return binding.root
    }

}