package com.example.groceryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryapp.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        init()
    }

    private fun init() {
        val buttonReg = findViewById<Button>(R.id.btn_reg)
        buttonReg.setOnClickListener {
            startActivity(Intent(this@AuthActivity, RegistrationActivity::class.java))
        }

        val buttonLogin = findViewById<Button>(R.id.btn_login)
        buttonLogin.setOnClickListener {
            startActivity(Intent(this@AuthActivity, LoginActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        finish()
    }

}