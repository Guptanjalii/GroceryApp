package com.example.groceryapp.models

import java.io.Serializable

data class Category(
    val categoryId: String,
    val categoryName: String,
    val categoryImg: Int,
    val subCategory: List<SubCategory>
): Serializable {
    companion object{
        const val KEY_DATA = "CATEGORY_DATA"
    }
}
