package com.example.groceryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.groceryapp.R
import com.example.groceryapp.adapters.CategoryAdapter
import com.example.groceryapp.mocks.category
import com.example.groceryapp.models.Category

class HomeActivity : AppCompatActivity() {

    lateinit var categoryGRV: GridView
    lateinit var categoryList: List<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initializeImageSlider()
        initializeCategory()
    }

    private fun initializeImageSlider() {
        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.pic2, ""))
        imageList.add(SlideModel(R.drawable.pic1, ""))
        imageList.add(SlideModel(R.drawable.pic3, ""))
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }

    private fun initializeCategory() {
        // initializing variables of grid view with their ids.
        categoryGRV = findViewById(R.id.grid_view)
        categoryList = ArrayList<Category>()
        categoryList = category


        // on below line we are initializing our course adapter
        // and passing course list and context.
        val courseAdapter = CategoryAdapter(categoryList = categoryList, this@HomeActivity)

        // on below line we are setting adapter to our grid view.
        categoryGRV.adapter = courseAdapter

        // on below line we are adding on item
        // click listener for our grid view.

        categoryGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->   onActionClick(position) }
    }

    private fun onActionClick(position: Int) {
        val selectedCategoryData = categoryList[position]

        if (selectedCategoryData.subCategory.size === 1) {
            val intent = Intent(this@HomeActivity, ListActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        } else if (selectedCategoryData.subCategory.size > 0) {
            val intent = Intent(this@HomeActivity, TabActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        } else {
            startActivity(Intent(this@HomeActivity, NoDataActivity::class.java))
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@HomeActivity, AuthActivity::class.java)
        startActivity(intent)
    }
}