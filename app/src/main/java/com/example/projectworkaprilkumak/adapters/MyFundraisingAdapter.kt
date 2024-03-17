package com.example.projectworkaprilkumak.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.projectworkaprilkumak.database.MyBase
import com.example.projectworkaprilkumak.databinding.ItemMyfundraisingBinding
import com.example.projectworkaprilkumak.datas.ImageUser
import com.example.projectworkaprilkumak.datas.MyFundraisingData

class MyFundraisingAdapter(var context: Context,var myFundraisingList:MutableList<MyFundraisingData>) :
    RecyclerView.Adapter<MyFundraisingAdapter.MyFundraisingHolder>(){
      var myBase = MyBase(context)
      var imageList = ArrayList<ImageUser>()
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
        addAll()
        imageList.forEach {
            if (it.id == myFundraising.imgId){
                holder.img.setImageURI(Uri.parse(it.absolutePath))
                val bitmap = BitmapFactory.decodeByteArray(it.image,0,it.image!!.size)
                holder.img.setImageBitmap(bitmap)
            }
        }
        holder.title.text = myFundraising.title
        holder.toRaise.text = myFundraising.toRaise.toString()
        holder.raised.text = myFundraising.raised.toString()
        holder.donN.text = myFundraising.donN.toString()
        holder.dayL.text = myFundraising.daysLeft.toString()

        holder.edit.setOnClickListener {
            Toast.makeText(context, "Working as well", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return myFundraisingList.size
    }
    fun addAll(){
        imageList.addAll(myBase.getAllImage())

    }
}

/*
val list = ArrayList<ImageUser>()
            list.addAll(myBase.getAllImage())
            if (list.isNotEmpty()){
                binding.addPic.setImageURI(Uri.parse(list[0].absolutePath))
                val bitmap = BitmapFactory.decodeByteArray(list[0].image,0,list[0].image!!.size)
                binding.addPic.setImageBitmap(bitmap)
            }
 */