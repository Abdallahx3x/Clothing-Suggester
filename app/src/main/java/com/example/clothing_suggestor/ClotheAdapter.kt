package com.example.clothing_suggestor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clothing_suggestor.databinding.ItemClotheBinding

class ClotheAdapter(private val  list: MutableList<ClotheImage>): RecyclerView.Adapter<ClotheAdapter.ClotheViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClotheViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_clothe,parent,false)
        return ClotheViewHolder(view)
    }


    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ClotheViewHolder, position: Int){
        val i=list[position]
        holder.binding.itemClothe.setImageResource(i.image)

    }


    class ClotheViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem){

        val binding= ItemClotheBinding.bind(viewItem)

    }
}