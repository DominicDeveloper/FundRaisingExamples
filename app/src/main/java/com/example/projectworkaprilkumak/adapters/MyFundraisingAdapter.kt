package com.example.projectworkaprilkumak.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.databinding.ItemMyfundraisingBinding
import com.example.projectworkaprilkumak.datas.MyFundraisingData

class MyFundraisingAdapter(var myFundraisingList:MutableList<MyFundraisingData>) :
    RecyclerView.Adapter<MyFundraisingAdapter.MyFundraisingHolder>(){
    class MyFundraisingHolder(binding: ItemMyfundraisingBinding) : RecyclerView.ViewHolder(binding.root){
        var mainCard = binding.mainCard
        var title = binding.urgentTitle
        var img = binding.urgentI
        var raised = binding.urgentRaisedFund
        var toRaise = binding.urgentToRaise
        var donN = binding.urgentDonatorQuantity
        var dayL = binding.UrgentLeftDays
        var bookmark = binding.bIc
        var edit = binding.edit
        var seeResults = binding.seeResults
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFundraisingHolder {
      return MyFundraisingHolder(ItemMyfundraisingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyFundraisingHolder, position: Int) {
        var myFundraising = myFundraisingList[position]

        holder.img.setImageResource(myFundraising.img)
        holder.title.text = myFundraising.title
        holder.toRaise.text = myFundraising.toRaise.toString()
        holder.raised.text = myFundraising.raised.toString()
        holder.donN.text = myFundraising.donN.toString()
        holder.dayL.text = myFundraising.daysLeft.toString()


        holder.edit.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return myFundraisingList.size
    }
}