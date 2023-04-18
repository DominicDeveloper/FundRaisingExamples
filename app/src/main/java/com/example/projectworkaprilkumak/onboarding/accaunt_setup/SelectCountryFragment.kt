package com.example.projectworkaprilkumak.onboarding.accaunt_setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.adapters.CountryAdapter
import com.example.projectworkaprilkumak.databinding.FragmentSelectCountryBinding
import com.example.projectworkaprilkumak.datas.Country


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SelectCountryFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var listC = mutableListOf<Country>()
    private lateinit var adapter: CountryAdapter


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

        createCountry()
        val binding = FragmentSelectCountryBinding.inflate(inflater, container, false)

        var toolbar: Toolbar = binding.toolbar
        val activity : AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)

        toolbar.setNavigationOnClickListener { findNavController().navigate(R.id.action_selectCountryFragment_to_signUpFragment )}


        adapter = CountryAdapter(requireContext(), listC)
        binding.countryList.adapter = adapter

        binding.continueBtn.setOnClickListener { findNavController().navigate(R.id.action_selectCountryFragment_to_fillProfile) }

        binding.search.addTextChangedListener {
            val filter = mutableListOf<Country>()
            if (it != null) {
                for (c in listC) {
                    if (c.name.lowercase().contains(it.toString().lowercase())) {
                        filter.add(c)
                    }
                }
                adapter = CountryAdapter(requireContext(), filter)
                binding.countryList.adapter = adapter
            }
        }

        return binding.root
    }

    private fun createCountry() {

        for(i in 0..20){
            listC.add(Country("Afghanistan", R.drawable.flag_afghan, "AF"))
            listC.add(Country("India", R.drawable.flag_india, "In"))
            listC.add(Country("Malaysia", R.drawable.flag_malaysia, "Ml"))
            listC.add(Country("USA", R.drawable.flag_usa, "US"))
        }

    }
}