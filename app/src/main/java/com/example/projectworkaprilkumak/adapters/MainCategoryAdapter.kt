package com.example.projectworkaprilkumak.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.databinding.ItemCategoryBinding
import com.example.projectworkaprilkumak.datas.MainCategory

class MainCategoryAdapter(var mainCategories:MutableList<MainCategory>) : RecyclerView.Adapter<MainCategoryAdapter.MainCategoryHolder>(){
    class MainCategoryHolder(binding: ItemCategoryBinding):RecyclerView.ViewHolder(binding.root){
        var catN = binding.categoryT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryHolder {
        return MainCategoryHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainCategoryHolder, position: Int) {
        var category = mainCategories[position]
        holder.catN.text = category.categoryName
    }

    override fun getItemCount(): Int {
        return mainCategories.size
    }
}