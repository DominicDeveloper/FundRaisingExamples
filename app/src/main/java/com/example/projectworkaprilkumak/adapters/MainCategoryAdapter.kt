package com.example.projectworkaprilkumak.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.databinding.ItemCategoryBinding
import com.example.projectworkaprilkumak.datas.MainCategory

class MainCategoryAdapter(var mainCategories:Array<MainCategory>, var onClick: MyCategoryInterface) : RecyclerView.Adapter<MainCategoryAdapter.MainCategoryHolder>(){
    var selectedPos = -1

    class MainCategoryHolder(binding: ItemCategoryBinding):RecyclerView.ViewHolder(binding.root){
        var category_main = binding.categoryMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryHolder {
        return MainCategoryHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainCategoryHolder, position: Int) {
        var category = mainCategories[position]
        holder.category_main.text = category.categoryName

        holder.category_main.setOnClickListener {
            onClick.onItemClick(category, position)
            notifyItemChanged(selectedPos);
            selectedPos = position
            notifyItemChanged(selectedPos);
        }
    }

    override fun getItemCount(): Int {
        return mainCategories.size
    }

    interface MyCategoryInterface{
        fun onItemClick(category: MainCategory, position: Int)
    }
}