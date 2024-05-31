package com.example.groceryapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.groceryapp.fragments.ListFragment
import com.example.groceryapp.mocks.category
import com.example.groceryapp.models.Category

class ViewPagerAdapter(fragment: FragmentActivity, private val subCatList: ArrayList<String>, private val selectedCategory: Category): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return subCatList.size
    }

    override fun createFragment(position: Int): Fragment {
//        ListFragment.newInstance(selectedCategory.subCategory[position].productList.toString())
        return when(position) {
            0 -> ListFragment.newInstance(selectedCategory.subCategory[position].productList)
            else -> ListFragment.newInstance(selectedCategory.subCategory[position].productList)
        }
    }

}
