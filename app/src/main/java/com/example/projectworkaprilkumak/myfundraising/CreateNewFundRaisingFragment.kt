package com.example.projectworkaprilkumak.myfundraising

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentCreateNewFundRaisingBinding
import com.example.projectworkaprilkumak.datas.MyFundraisingData


class CreateNewFundRaisingFragment : Fragment() {

    private lateinit var binding: FragmentCreateNewFundRaisingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNewFundRaisingBinding.inflate(inflater, container, false)
        var img = binding.img.id
        var title = binding.title.text.toString()
        var category = binding.category.text.toString()
        var raised:Int
//        var newFund = MyFundraisingData(img, title, raised)


        return binding.root
    }


}