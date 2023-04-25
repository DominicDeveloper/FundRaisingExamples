package com.example.projectworkaprilkumak.myfundraising

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentEditMyFundraisingBinding


class EditMyFundraisingFragment : Fragment() {

    private lateinit var binding: FragmentEditMyFundraisingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentEditMyFundraisingBinding.inflate(inflater, container, false)

        return binding.root
    }

}