package com.example.projectworkaprilkumak.Home

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.adapters.MainCategoryAdapter
import com.example.projectworkaprilkumak.adapters.UrgentFAdapter
import com.example.projectworkaprilkumak.databinding.FragmentHomeBinding
import com.example.projectworkaprilkumak.datas.MainCategory
import com.example.projectworkaprilkumak.datas.UrgentFdata

class HomeFragment : Fragment() {

    private lateinit var urgents_adapter: UrgentFAdapter
    private lateinit var endings_adapter: UrgentFAdapter
    private lateinit var urgents: MutableList<UrgentFdata>
    private lateinit var endings: MutableList<UrgentFdata>
    private lateinit var categories: MutableList<MainCategory>
    private lateinit var binding: FragmentHomeBinding
    var selectedFilter = "all"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        var toolbar: Toolbar = binding.toolbar3
        val activity: AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)

//        binding.navBar.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.calendar -> findNavController().navigate(R.id.action_homeFragment_to_calendarFragment)
//                R.id.fundraising -> findNavController().navigate(R.id.action_homeFragment_to_myFundraisingFragment)
//                R.id.chat -> findNavController().navigate(R.id.action_homeFragment_to_chatFragment)
//                R.id.profile -> findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
//            }
//            true
//        }


        val list = loadUF()

        urgents_adapter = UrgentFAdapter(list)
        binding.urgentRV.adapter = urgents_adapter
        binding.urgentRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.categoryRV.adapter = MainCategoryAdapter(MainCategory.values(), object : MainCategoryAdapter.MyCategoryInterface{
            override fun onItemClick(category: MainCategory, position: Int) {
                var categoryList = mutableListOf<UrgentFdata>()
                if (category.categoryName=="All"){
                    categoryList.addAll(list)
                }
                list.forEach{
                    if (it.category==category) categoryList.add(it)
                }
                urgents_adapter = UrgentFAdapter(categoryList)
            binding.urgentRV.adapter = urgents_adapter
            }
        })

        binding.categoryRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.urgentRV)


        endings = mutableListOf()
        list.forEach{
            if (it.u_dLeft<10){
                endings.add(it)
            }
        }
        endings_adapter = UrgentFAdapter(endings)
        binding.endingRV.adapter = endings_adapter
        binding.endingRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)




        return binding.root

    }

private fun loadUF() : MutableList<UrgentFdata>{
    urgents = mutableListOf()


    for(i in 0..1){
        urgents.add(UrgentFdata(R.drawable.orphanage_children, "Help Orphanage Children to..", 2379,4200,1280,19,MainCategory.HUMANITY))
        urgents.add(UrgentFdata(R.drawable.victim_volcano, "Help Victims of the Impact...", 2777, 6310, 938, 26, MainCategory.DISASTER))
        urgents.add(UrgentFdata(R.drawable.victim_flood, "Help Victims of Flash Flood...", 8775, 10540,4471, 9, MainCategory.DISASTER))
        urgents.add(UrgentFdata(R.drawable.sick_baby, "Help Little Baby to Do Stomach..", 2777, 6310, 5012, 12, MainCategory.SICKCHILD))
        urgents.add(UrgentFdata(R.drawable.cancer_child, "Help Kid to Overcome Cancer...", 3013, 4500, 2301, 2, MainCategory.SICKCHILD))
        urgents.add(UrgentFdata(R.drawable.victim_earthquake, "Help Victims of Earthquake", 4378, 7380, 2475, 5, MainCategory.DISASTER))
        urgents.add(UrgentFdata(R.drawable.new_school, "Help to Build a New School for kids", 5410, 12250, 3851, 3, MainCategory.INFRASTRUCTURE))
        urgents.add(UrgentFdata(R.drawable.hungry_kids, "Help Hungry Kids", 3850, 6723, 2104, 1, MainCategory.HUMANITY))
    }

    return urgents
}

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.bookmark -> {
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