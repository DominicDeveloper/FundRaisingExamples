package com.example.projectworkaprilkumak.onboarding

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentSignUpBinding
import com.example.projectworkaprilkumak.datas.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignUpBinding.inflate(inflater,container,false)
        var userList = mutableListOf<User>()
        var sharedPreferences = this.requireActivity().getSharedPreferences("reg", Context.MODE_PRIVATE)
        var edit = sharedPreferences.edit()
        var gson = Gson()
        var type = object : TypeToken<List<User>>() {}.type
        binding.signupBtn.setOnClickListener {
            var pos = false
            var users = sharedPreferences.getString("users", "")
            if (users == ""){
                userList.add(User(binding.signupEmail.text.toString(), binding.signupPassword.text.toString()))
                val str = gson.toJson(userList)
                edit.putString("users", str).commit()
            } else{
                userList = gson.fromJson(users, type)
                for (i in userList){
                    if (i.email!=binding.signupEmail.text.toString() && i.password!=binding.signupPassword.text.toString()){
                        pos = true
                    } else{
                        pos = false
                        break
                    }
                }
                if (pos==true){
                    userList.add(User(binding.signupEmail.text.toString(), binding.signupPassword.text.toString()))
                    Toast.makeText(requireContext(), "Successfully registered", Toast.LENGTH_SHORT).show()
                    val str = gson.toJson(userList)
                    edit.putString("users", str).commit()
                    findNavController().navigate(R.id.action_signUpFragment_to_selectCountryFragment)
                } else{
                    Toast.makeText(requireContext(), "Change inputs", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.signinTv.setOnClickListener { findNavController().navigate(R.id.action_signUpFragment_to_signInFragment) }

        return binding.root

    }

}