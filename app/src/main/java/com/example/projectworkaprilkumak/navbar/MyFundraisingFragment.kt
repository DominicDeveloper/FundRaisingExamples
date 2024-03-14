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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.adapters.MyFundraisingAdapter
import com.example.projectworkaprilkumak.databinding.FragmentMyFundraisingBinding
import com.example.projectworkaprilkumak.datas.MainCategory
import com.example.projectworkaprilkumak.datas.MyFundraisingData

class MyFundraisingFragment : Fragment() {
    private lateinit var binding: FragmentMyFundraisingBinding
    private lateinit var adapter: MyFundraisingAdapter
    private lateinit var list:MutableList<MyFundraisingData>
    private lateinit var funds:MutableList<MyFundraisingData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyFundraisingBinding.inflate(inflater, container, false)

        list = loadUF()



        adapter = MyFundraisingAdapter(list)

        binding.myFundraisingRV.adapter = adapter
        binding.myFundraisingRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.addFab.setOnClickListener { findNavController().navigate(R.id.createNewFundRaisingFragment) }


     return binding.root
    }

    private fun loadUF() : MutableList<MyFundraisingData>{

        funds = mutableListOf()

        funds.add(
            MyFundraisingData(R.drawable.orphanage_children, "Help Orphanage Children to..", 2379,4200,1280,19,
                MainCategory.HUMANITY)
        )
        funds.add(MyFundraisingData(R.drawable.victim_volcano, "Help Victims of the Impact...", 2777, 6310, 938, 26, MainCategory.DISASTER))
        funds.add(MyFundraisingData(R.drawable.victim_flood, "Help Victims of Flash Flood...", 8775, 10540,4471, 9, MainCategory.DISASTER))

        funds.add(MyFundraisingData(R.drawable.victim_earthquake, "Help Victims of Earthquake", 4378, 7380, 2475, 5, MainCategory.DISASTER))
        funds.add(MyFundraisingData(R.drawable.new_school, "Help to Build a New School for kids", 5410, 12250, 3851, 3, MainCategory.INFRASTRUCTURE))
        funds.add(MyFundraisingData(R.drawable.hungry_kids, "Help Hungry Kids", 3850, 6723, 2104, 1, MainCategory.HUMANITY))
        funds.add(MyFundraisingData(R.drawable.hungry_kids, "Help Hungry Kids", 3850, 6723, 2104, 1, MainCategory.HUMANITY))
        funds.add(MyFundraisingData(R.drawable.poor_indian_student, "Help to Study in London", 2100, 2277, 577, 8, MainCategory.EDUCATION))
        funds.add(MyFundraisingData(R.drawable.africa_disabled_man, "Help this disabled man", 5721, 6740, 3333, 7, MainCategory.DISABLE))
        funds.add(MyFundraisingData(R.drawable.hungry_kids, "Help to Give Them Food", 1245, 2456, 1204, 1, MainCategory.HUMANITY))



        return funds
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bookmark -> {
                findNavController().navigate(R.id.action_myFundraisingFragment_to_bookmarkFragment)
            }
            R.id.notification -> {
                findNavController().navigate(R.id.action_myFundraisingFragment_to_notificationFragment)
            }
            R.id.search ->{
                findNavController().navigate(R.id.action_myFundraisingFragment_to_searchFragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}