package com.example.projectworkaprilkumak.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.databinding.ItemUrgentFBinding
import com.example.projectworkaprilkumak.datas.UrgentFdata

class UrgentFAdapter(var urgents:MutableList<UrgentFdata>):RecyclerView.Adapter<UrgentFAdapter.UrgentFHolder>() {
    class UrgentFHolder(binding: ItemUrgentFBinding):RecyclerView.ViewHolder(binding.root){
        var urgent_image = binding.urgentI
        var urgent_title = binding.urgentTitle
        var urgent_raised = binding.urgentRaisedFund
        var urgent_toraise = binding.urgentToRaise
        var urgent_donators = binding.urgentDonatorQuantity
        var urgent_leftdays = binding.UrgentLeftDays
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrgentFHolder {
        return UrgentFHolder(ItemUrgentFBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UrgentFHolder, position: Int) {
        var urgentF = urgents[position]
        holder.urgent_image.setImageResource(urgentF.u_i)
        holder.urgent_title.text = urgentF.u_t
        holder.urgent_raised.text = urgentF.u_raised.toString()
        holder.urgent_toraise.text = urgentF.u_toRaise.toString()
        holder.urgent_donators.text = urgentF.u_don.toString()
        holder.urgent_leftdays.text = urgentF.u_dLeft.toString()
    }

    override fun getItemCount(): Int {
        return urgents.size
    }
}