package com.example.groceryapp.models

import java.io.Serializable

data class User(
    var name: String,
    var mobile: String,
    var email: String,
    var pwd: String
): Serializable{
    companion object{
        const val KEY_DATA = "USER_DATA"
    }
}
