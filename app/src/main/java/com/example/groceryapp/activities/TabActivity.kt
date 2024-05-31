package com.example.groceryapp.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.groceryapp.R
import com.example.groceryapp.adapters.ViewPagerAdapter
import com.example.groceryapp.mocks.category
import com.example.groceryapp.models.Category
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {
    lateinit var selectedCategory: Category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tab)

        var selectedCategoryPosition = intent.getIntExtra("position", 1)
        selectedCategory = category[selectedCategoryPosition]

        var subCategories = ArrayList<String>()

        for (data in selectedCategory.subCategory) {
            subCategories.add(data.subCategoryName)
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = ViewPagerAdapter(this, subCategories, selectedCategory)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = subCategories[0]
                else -> tab.text = subCategories[position]
            }
        }.attach()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}