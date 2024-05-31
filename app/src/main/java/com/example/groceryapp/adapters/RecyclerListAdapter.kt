package com.example.groceryapp.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.activities.ProductDetailActivity
import com.example.groceryapp.models.Product


class RecyclerListAdapter(var mList: ArrayList<Product>) : RecyclerView.Adapter<RecyclerListAdapter.MyViewHolder>() {
    lateinit var productName: String

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerListAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_adapter_product, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerListAdapter.MyViewHolder, position: Int) {
        val currentItem = mList[position]
        holder.productName.text = currentItem.productName
        holder.productPrice.text = "Price: Rs.${currentItem.productPrice.toString()}"
        if (currentItem.stockStatus === true) {
            holder.status.text  = "In stock"
            holder.status.setTextColor(Color.parseColor("#50C878"))
        } else {
            holder.status.text = "Out of stock"
            holder.status.setTextColor(Color.parseColor("#D30000"))
        }
        Glide.with(holder.productImg.getContext())
            .load(currentItem.productImg)
            .into(holder.productImg)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("Product", currentItem)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val productName = itemView.findViewById<TextView>(R.id.prod_title)
        val productPrice = itemView.findViewById<TextView>(R.id.prod_price)
        val productImg = itemView.findViewById<ImageView>(R.id.prod_image)
        val status = itemView.findViewById<TextView>(R.id.prod_status)
    }
}