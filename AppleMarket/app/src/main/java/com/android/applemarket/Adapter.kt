package com.android.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.RecyclerviewPostBinding
import java.text.DecimalFormat

class Adapter(val postList: MutableList<Post>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val productView =
            RecyclerviewPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Log.d("Adapter", "onCreateViewHolder()")
        return MyViewHolder(productView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Log.d("Adapter", "onBindViewHolder()  position = $position")
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        val postList = postList[position]
        // 1000단위 , 찍기
        val decimal = DecimalFormat("#,###")

        holder.photo.setImageResource(postList.itemPhoto)
        holder.name.text = postList.itemName
        holder.address.text = postList.itemLocation
        holder.price.text = decimal.format(postList.itemPrice) + "원"
        holder.comment.text = postList.itemComment.toString()
        holder.heart.text = postList.itemHeart.toString()
    }

    override fun getItemCount() = postList.size

    inner class MyViewHolder(binding: RecyclerviewPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val photo = binding.ivPhoto
        val name = binding.tvName
        val address = binding.tvAddress
        val price = binding.tvPrice
        val comment = binding.tvComment
        val heart = binding.tvLike
    }


}