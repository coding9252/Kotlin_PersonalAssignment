package com.android.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.ItemBinding
import java.text.DecimalFormat

class Adapter(val saleItemList: MutableList<SaleItem>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    interface ItemLongClick {
        fun onLongClick(view : View, position : Int)
    }

    var itemClick: ItemClick? = null
    var itemLongClick : ItemLongClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val productView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Log.d("Adapter", "onCreateViewHolder()")
        return MyViewHolder(productView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Log.d("Adapter", "onBindViewHolder()  position = $position")
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener() OnLongClickListener@{
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }

        val postList = saleItemList[position]
        // 1000단위 , 찍기
        val decimal = DecimalFormat("#,###")

        holder.photo.setImageResource(postList.itemPhoto)
        holder.name.text = postList.itemName
        holder.address.text = postList.itemLocation
        holder.price.text = decimal.format(postList.itemPrice) + "원"
        holder.comment.text = postList.itemComment.toString()
        holder.like.text = postList.likeCount.toString()

        if(saleItemList[position].isLike)
            holder.likeIcon.setImageResource(R.drawable.like2)
        else
            holder.likeIcon.setImageResource(R.drawable.like)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount() = saleItemList.size

    inner class MyViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val photo = binding.ivPhoto
        val name = binding.tvName
        val address = binding.tvAddress
        val price = binding.tvPrice
        val comment = binding.tvComment
        val like = binding.tvLike
        val likeIcon = binding.ivLikeCount
    }


}