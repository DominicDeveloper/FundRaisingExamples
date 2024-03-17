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
import com.example.projectworkaprilkumak.database.MyBase
import com.example.projectworkaprilkumak.databinding.FragmentMyFundraisingBinding
import com.example.projectworkaprilkumak.datas.MainCategory
import com.example.projectworkaprilkumak.datas.MyFundraisingData

class MyFundraisingFragment : Fragment() {
    private lateinit var binding: FragmentMyFundraisingBinding
    private lateinit var adapter: MyFundraisingAdapter
    lateinit var myBase: MyBase
    private lateinit var list:MutableList<MyFundraisingData>
    private lateinit var funds:MutableList<MyFundraisingData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyFundraisingBinding.inflate(inflater, container, false)
        myBase = MyBase(requireContext())
        list = loadUF()


        adapter = MyFundraisingAdapter(requireContext(),list)
        binding.myFundraisingRV.adapter = adapter
        binding.myFundraisingRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.addFab.setOnClickListener { findNavController().navigate(R.id.createNewFundRaisingFragment) }


     return binding.root
    }

    private fun loadUF() : MutableList<MyFundraisingData>{

        funds = mutableListOf()
        if (myBase.getAllFundraisingData().isNotEmpty()){
            funds.addAll(myBase.getAllFundraisingData())
        }else if (myBase.getAllFundraisingData().isEmpty()){
            // ma`lumot bo`sh bo`ladi, biron bir narsa yozib qo`yish mumkin,
            // fund larning xammasi database ga saqlanadi. databasedan olish -> myBase.getAllFundraisingData()
            // fund-lar list tipida keladi mutablelist ga o`tkazish shart emas ArrayList dan foydalanilgan yaxshiroq
        }

        return funds
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()
       
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bookmark -> {
                findNavController().navigate(R.id.bookmarkFragment)
            }
            R.id.notification -> {
                findNavController().navigate(R.id.notificationFragment)
            }
            R.id.search ->{
                findNavController().navigate(R.id.searchFragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}