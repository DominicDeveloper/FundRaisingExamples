package com.example.projectworkaprilkumak.myfundraising

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentCreateNewFundRaisingBinding
import com.example.projectworkaprilkumak.datas.MainCategory
import com.example.projectworkaprilkumak.datas.MyFundraisingData


class CreateNewFundRaisingFragment : Fragment() {

    private lateinit var binding: FragmentCreateNewFundRaisingBinding
    private lateinit var category: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNewFundRaisingBinding.inflate(inflater, container, false)
        var img = binding.img.id
        var title = binding.title.text.toString()
        var raised:Int
//        var newFund = MyFundraisingData(img, title, raised)

        var categories = resources.getStringArray(R.array.createFundraising_categories)
        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_category, categories)
        binding.dropdownCategories.setAdapter(categoryAdapter)
        binding.dropdownCategories.setOnItemClickListener { adapterView, view, i, l ->
            category = categories[i]
        }



        return binding.root
    }


}