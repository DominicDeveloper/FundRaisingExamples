package com.example.projectworkaprilkumak.myfundraising

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentCreateNewFundRaisingBinding
import com.example.projectworkaprilkumak.datas.MainCategory
import com.example.projectworkaprilkumak.datas.MyFundraisingData
import com.example.projectworkaprilkumak.datas.Profile


class CreateNewFundRaisingFragment : Fragment() {

    private lateinit var binding: FragmentCreateNewFundRaisingBinding
    private lateinit var category: String
    private lateinit var addImageView: ImageView
    private lateinit var addImageViewButton: Button

    companion object{
        const val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCreateNewFundRaisingBinding.inflate(inflater, container, false)
        addImageView = binding.addPic
        addImageViewButton = binding.addPicBtn
        var title = binding.title.text.toString()
        var raised:Int
//z        var newFund = MyFundraisingData(img, title, raised)

        var categories = resources.getStringArray(R.array.createFundraising_categories)
        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_category, categories)
        binding.dropdownCategories.setAdapter(categoryAdapter)
        binding.dropdownCategories.setOnItemClickListener { adapterView, view, i, l ->
            category = categories[i]
        }

        addImageViewButton.setOnClickListener {
            pickImageGallery()
        }


        return binding.root

    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            addImageView.setImageURI(data?.data)
        }
    }


}