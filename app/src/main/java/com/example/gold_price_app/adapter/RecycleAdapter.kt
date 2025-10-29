package com.example.gold_price_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gold_price_app.databinding.ItemRecycleGoldBinding
import com.example.gold_price_app.remote.model.gold.Content

class RecycleAdapter(

    private val allData: ArrayList<Content>,
    private val icon : ArrayList<Int>
):RecyclerView.Adapter<RecycleAdapter.GoldViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoldViewHolder {

return GoldViewHolder(
    ItemRecycleGoldBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    ))
    }

    override fun getItemCount(): Int = allData.size



    override fun onBindViewHolder(holder: GoldViewHolder, position: Int) {
        holder.saveData(allData[position],icon[position])

    }

    inner class  GoldViewHolder(
        private val binding:ItemRecycleGoldBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun saveData(data : Content ,id: Int){
            binding.txtName.text=data.label
           val price=(data.price/10).toString().reversed().chunked(3).joinToString(",")
            binding.txtPrice.text=price.reversed()
            binding.icon.setImageResource(id)


        }

    }
}