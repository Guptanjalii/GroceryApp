package com.example.groceryapp.adapters

import android.content.Context
import android.graphics.Color
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.models.Product

class ListAdapter(var mContext: Context, var mList: ArrayList<Product>, private var listener: RecyclerViewEvent) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var onItemClick : ((Product) -> Unit)? = null

    // called only once to setup the layout for the row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_adapter_product, parent, false)
        return MyViewHolder(view)
    }

    // number of rows
    override fun getItemCount(): Int {
        return mList.size
    }

    // will be called for every row
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var product = mList[position]
        holder.bind(product)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        fun bind(product: Product) {
            itemView.findViewById<TextView>(R.id.prod_title).text = product.productName
            itemView.findViewById<TextView>(R.id.prod_price).text = "Price: Rs.${product.productPrice.toString()}"

            Glide.with(mContext)
                .load(product.productImg)
                .into(itemView.findViewById<ImageView>(R.id.prod_image))

            val status = itemView.findViewById<TextView>(R.id.prod_status)
            if (product.stockStatus === true) {
                status.text = "In stock"
                status.setTextColor(Color.parseColor("#50C878"))
            } else {
                status.text = "Out of stock"
                status.setTextColor(Color.parseColor("#D30000"))
            }
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }

}