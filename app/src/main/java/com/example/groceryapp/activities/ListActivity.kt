package com.example.groceryapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.adapters.ListAdapter
import com.example.groceryapp.mocks.category
import com.example.groceryapp.models.Category
import com.example.groceryapp.models.Product

class ListActivity : AppCompatActivity(), ListAdapter.RecyclerViewEvent {
    var mList: ArrayList<Product> = ArrayList()
    lateinit var selectedCategory: Category
    var selectedCategoryPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        init()
    }

    private fun init() {
        generateData()
        // recycle view
        val mRecycleView = findViewById<RecyclerView>(R.id.list_recycle_view)
        // adapter
        val adapterList = ListAdapter(this, mList, this)
        // layout manager
        val mLayoutManager = LinearLayoutManager(this)
        // setup recycle view
        mRecycleView.adapter = adapterList
        mRecycleView.layoutManager = mLayoutManager
    }

    private fun generateData() {
        selectedCategoryPosition = intent.getIntExtra("position", 1)
        selectedCategory = category[selectedCategoryPosition]

        var selectedSubCategory = selectedCategory.subCategory
        mList = selectedSubCategory[0].productList as ArrayList<Product>
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("Product", mList[position])
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}