package com.example.projectworkaprilkumak.navbar

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.databinding.FragmentMyFundraisingBinding

class MyFundraisingFragment : Fragment() {
    private lateinit var binding: FragmentMyFundraisingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyFundraisingBinding.inflate(inflater, container, false)

        binding.addFab.imageTintList = ColorStateList.valueOf(Color.rgb(255, 50, 50))

     return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bookmark -> {
//                Log.d("MyDataB", "${bookmarkedList}")
//                val bundle = Bundle()
//                bundle.putSerializable("bookmarkedList", bookmarkedList as ArrayList)
                findNavController().navigate(R.id.action_homeFragment_to_bookmarkFragment)
            }
            R.id.notification -> {
                Toast.makeText(requireContext(), "This is notification", Toast.LENGTH_SHORT)
            }
            R.id.search ->{
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}