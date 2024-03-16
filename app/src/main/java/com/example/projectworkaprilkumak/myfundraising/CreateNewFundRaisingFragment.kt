package com.example.projectworkaprilkumak.myfundraising

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentCreateNewFundRaisingBinding
import com.example.projectworkaprilkumak.datas.MainCategory
import com.example.projectworkaprilkumak.datas.MyFundraisingData
import com.example.projectworkaprilkumak.datas.Profile
import java.io.File


class CreateNewFundRaisingFragment : Fragment() {

    private lateinit var binding: FragmentCreateNewFundRaisingBinding
    private lateinit var category: String
    private lateinit var addImageView: ImageView
    private lateinit var addImageViewButton: Button
    private lateinit var toolbar: Toolbar
    private lateinit var myFundraisingList: MutableList<MyFundraisingData>
    private lateinit var imageUri: Uri

    companion object{
        const val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCreateNewFundRaisingBinding.inflate(inflater, container, false)


        toolbar = binding.toolbar
        val activity : AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)


        addImageView = binding.addPic
        addImageViewButton = binding.addPicBtn


        var categories = resources.getStringArray(R.array.createFundraising_categories)
        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_category, categories)
        binding.dropdownCategories.setAdapter(categoryAdapter)
        binding.dropdownCategories.setOnItemClickListener { adapterView, view, i, l ->
            category = categories[i]
        }


        addImageViewButton.setOnClickListener {
            pickImageGallery()
        }

        binding.donationProposalDoc.setOnClickListener {
            showFileChooser()
        }

        binding.medDoc.setOnClickListener {
            showFileChooser()
        }


////////////////////////////////
        binding.continueBtn.setOnClickListener {
            myFundraisingList.add(MyFundraisingData(addImageView.base   , "55", 55, 55, 55, 55, category))
        }


        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }


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

        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
            val uri: Uri? = data.data
            val path: String = uri?.path.toString()
            val file = File(path)
//            binding.donationProposalDoc.hint = "Path: $path File name: ${file.name}".trimIndent()
        }
    }


    private fun showFileChooser() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        try {
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 100)
        } catch (exception: Exception){
            Toast.makeText(requireContext(), "Please install a file manager.", Toast.LENGTH_SHORT).show()
        }
    }

}


