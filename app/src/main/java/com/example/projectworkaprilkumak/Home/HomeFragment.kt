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
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.R
import com.example.projectworkaprilkumak.adapters.MainCategoryAdapter
import com.example.projectworkaprilkumak.databinding.FragmentHomeBinding
import com.example.projectworkaprilkumak.datas.MainCategory

class HomeFragment : Fragment() {

    private lateinit var adapter: MainCategoryAdapter
    private lateinit var categories: MutableList<MainCategory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)


        var toolbar: Toolbar = binding.toolbar3
        val activity: AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(true)

        categories = mutableListOf()

        categories.add(MainCategory("All"))
        categories.add(MainCategory("Medical"))
        categories.add(MainCategory("Disaster"))
        categories.add(MainCategory("Education"))
        categories.add(MainCategory("Infrastructure"))
        categories.add(MainCategory("Sick child"))
        categories.add(MainCategory("Art"))
        categories.add(MainCategory("Orphanage"))
        categories.add(MainCategory("Disable"))
        categories.add(MainCategory("Humanity"))


        adapter = MainCategoryAdapter(categories)

        binding.categoryRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRV.adapter = adapter




        return binding.root

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