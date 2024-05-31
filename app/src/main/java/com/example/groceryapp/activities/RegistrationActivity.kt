package com.example.groceryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryapp.R
import com.example.groceryapp.models.User

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        init()
    }

    private fun init() {
        val textClickReg = findViewById<TextView>(R.id.reg_click)
        textClickReg.setOnClickListener {
            startActivity(Intent(this@RegistrationActivity, LoginActivity::class.java))
        }

        val buttonReg= findViewById<Button>(R.id.btn_reg)

        var name = findViewById<EditText>(R.id.reg_name)
        var mobile = findViewById<EditText>(R.id.reg_mobile)
        var email = findViewById<EditText>(R.id.reg_email)
        var pwd = findViewById<EditText>(R.id.reg_pwd)

        buttonReg.setOnClickListener {
            var user = User(
                name.text.toString(),
                mobile.text.toString(),
                email.text.toString(),
                pwd.text.toString()
            )
            name.setText("")
            mobile.setText("")
            email.setText("")
            pwd.setText("")
            val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
            intent.putExtra(User.KEY_DATA, user)
            startActivity(intent)
        }
    }
}