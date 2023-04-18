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
import com.example.projectworkaprilkumak.databinding.FragmentSignInBinding
import com.example.projectworkaprilkumak.datas.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignInBinding.inflate(inflater, container, false)
        var sharedPreferences = this.requireActivity().getSharedPreferences("reg", Context.MODE_PRIVATE)
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type

        binding.signinBtn.setOnClickListener {
            var users = sharedPreferences.getString("users", "")
            var pos = false

            if(users == ""){
                Toast.makeText(requireContext(), "Entered empty blanks!", Toast.LENGTH_SHORT).show()
            } else{
                userList = gson.fromJson(users, type)
                for(i in userList){
                    if (i.password == binding.signinPassword.text.toString() && i.email == binding.signinEmail.text.toString()){
                        pos = true
                        break
                    } else{
                        pos = false
                    }
                }

                if(pos==true) findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
                else Toast.makeText(requireContext(), "You have not registered yet!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signupTv.setOnClickListener {findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)}

        return binding.root
    }

}