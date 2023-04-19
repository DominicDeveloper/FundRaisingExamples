package com.example.projectworkaprilkumak.onboarding.accaunt_setup

import android.app.Dialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentCreatePinBinding
import com.google.gson.Gson
import kotlinx.coroutines.flow.combine

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CreatePinFragment : Fragment(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentCreatePinBinding

    private var listPin = mutableListOf<String>()
    private var index = 0
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    private lateinit var getPreferencesState: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentCreatePinBinding.inflate(inflater, container, false)

        var toolbar: Toolbar = binding.toolbar2
        val activity: AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)



        toolbar.setNavigationOnClickListener { findNavController().navigate(R.id.action_createPinFragment_to_selectInterestFragment) }

        val gson = Gson()

        getPreferences =
            this.requireActivity().getSharedPreferences("pin_code", AppCompatActivity.MODE_PRIVATE)
        getPreferencesState =
            this.requireActivity().getSharedPreferences("state", AppCompatActivity.MODE_PRIVATE)
        edit = getPreferences.edit()

    loadNumbers()

        binding.continueBtn.setOnClickListener {

            val s = gson.toJson(listPin)
            edit.putString("Users", s).apply()

            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.custom_dialog_window)
            val next = dialog.findViewById(R.id.continue_btn) as Button
            next.setOnClickListener { findNavController().navigate(R.id.action_createPinFragment_to_homeFragment)
            dialog.dismiss()}
            dialog.show()
        }
        return binding.root
    }

    private fun loadNumbers() {
        binding.one.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five.setOnClickListener(this)
        binding.six.setOnClickListener(this)
        binding.seven.setOnClickListener(this)
        binding.eight.setOnClickListener(this)
        binding.nine.setOnClickListener(this)
        binding.zero.setOnClickListener(this)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreatePinFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {
        if (listPin.size<4){
            listPin.add(p0!!.tag.toString())
            index++
            when(index){
                1->binding.pin1.setBackgroundResource(R.drawable.checkbox_oval_checked)
                2->binding.pin2.setBackgroundResource(R.drawable.checkbox_oval_checked)
                3->binding.pin3.setBackgroundResource(R.drawable.checkbox_oval_checked)
                4->binding.pin4.setBackgroundResource(R.drawable.checkbox_oval_checked)
            }
        }
        if (listPin.size==4){
            binding.continueBtn.visibility = View.VISIBLE
        }
    }

}