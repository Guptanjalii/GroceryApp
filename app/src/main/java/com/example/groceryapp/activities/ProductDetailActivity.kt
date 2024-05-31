package com.example.groceryapp.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.groceryapp.R
import com.example.groceryapp.models.Product

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_detail)

        setProductData()
    }

    private fun setProductData() {
        val product = intent.getParcelableExtra<Product>("Product")

        if (product != null) {
            val title = findViewById<TextView>(R.id.prod_detail_title)
            val image = findViewById<ImageView>(R.id.prod_detail_image)
            val price = findViewById<TextView>(R.id.prod_detail_price)
            val status = findViewById<TextView>(R.id.prod_detail_status)
            val cartBtn = findViewById<Button>(R.id.cart_button)

            title.text = product.productName
            Glide.with(this)
                .load(product.productImg)
                .into(image);
            price.text = "Price: Rs. ${product.productPrice.toString()}"
            if (product.stockStatus === true) {
                status.text = "In Stock"
                status.setTextColor(Color.parseColor("#50C878"))
            } else {
                status.text = "Out of Stock"
                status.setTextColor(Color.parseColor("#D30000"))
                cartBtn.setBackgroundColor(Color.parseColor("#F3B356"))
                cartBtn.isClickable = false
                cartBtn.isEnabled = false
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}