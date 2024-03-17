package com.example.projectworkaprilkumak.myfundraising

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.database.MyBase
import com.example.projectworkaprilkumak.databinding.FragmentCreateNewFundRaisingBinding
import com.example.projectworkaprilkumak.datas.ImageUser
import com.example.projectworkaprilkumak.datas.MyFundraisingData
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class CreateNewFundRaisingFragment : Fragment() {
    lateinit var myBase: MyBase
    var imageUser = ImageUser()
    private lateinit var binding: FragmentCreateNewFundRaisingBinding
    private lateinit var toolbar: Toolbar
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateNewFundRaisingBinding.inflate(inflater, container, false)

        toolbar = binding.toolbar
        val activity : AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)
        myBase = MyBase(requireContext())
        binding.addPicBtn.setOnClickListener {
            getNewImage()
        }


        val categoryList = listOf("Education","Environment","Social","Sick Child","Medical","Infrastructure","Art","Disaster","Orphanage","Disable","Humanity","Others")
        // array ichidagi kategoriyalar kelmadi listOf dan foydalanildi
        //  val categories = resources.getStringArray(R.array.createFundraising_categories)
        val adapter = ArrayAdapter(requireContext(),R.layout.dropdown_category,categoryList)
        adapter.notifyDataSetChanged()
        binding.categoryView.setAdapter(adapter)

        binding.textInputDropDown.setEndIconOnClickListener {
            // ikonka bosilganda kategoriyalar chiqadi
            binding.categoryView.showDropDown()
        }



        binding.donationProposalDoc.setOnClickListener {
            showFileChooser()
        }

        binding.medDoc.setOnClickListener {
            showFileChooser()
        }


        binding.continueBtn.setOnClickListener {
            myBase.insertImage(imageUser)
            val lastIndex = myBase.getAllImage().last().id!!.toInt()
            myBase.addFundraisingData(MyFundraisingData(binding.title.text.toString(),lastIndex,55,binding.totalDon.text.toString().toInt(), binding.totalDon.text.toString().toInt(),binding.expireDate.text.toString().toInt(),binding.categoryView.text.toString(),binding.recipientsName.text.toString(), binding.donationProposalDoc.text.toString(),binding.medDoc.text.toString(),binding.story.text.toString()))
            Toast.makeText(requireContext(), "Successful!", Toast.LENGTH_SHORT).show()
            binding.title.text!!.clear()
            binding.totalDon.text!!.clear()
            binding.expireDate.text!!.clear()
            binding.recipientsName.text!!.clear()
            binding.donationProposalDoc.text!!.clear()
            binding.medDoc.text!!.clear()
            binding.story.text!!.clear()
           }

        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }



        return binding.root

    }

    private val getImageContent =
        registerForActivityResult(ActivityResultContracts.GetContent()){
            it ?: return@registerForActivityResult
            binding.addPic.setImageURI(it)
            val inputStream = requireContext().contentResolver?.openInputStream(it)
            val file = File(requireContext().filesDir,"image.jpg")
            val fileOutputStream = FileOutputStream(file)
            inputStream?.copyTo(fileOutputStream)
            inputStream?.close()
            fileOutputStream?.close()
            val absoulut = file.absolutePath

            val fileInputStream = FileInputStream(file)
            val readBytes = fileInputStream.readBytes()
            imageUser = ImageUser(absoulut,readBytes)
        }

    private fun getNewImage() {
        getImageContent.launch("image/*")
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


