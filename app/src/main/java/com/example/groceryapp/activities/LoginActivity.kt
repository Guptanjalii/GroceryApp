package com.example.groceryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryapp.R
import com.example.groceryapp.models.User

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {
        val textClickLogin = findViewById<TextView>(R.id.login_click)
        textClickLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegistrationActivity::class.java))
        }

        val buttonLogin= findViewById<Button>(R.id.btn_login)
        buttonLogin.setOnClickListener {
            var email = findViewById<EditText>(R.id.login_email)
            var pwd = findViewById<EditText>(R.id.login_pwd)
            var user: User? = intent.getSerializableExtra(User.KEY_DATA) as? User
            val userEmail = email.text.toString()
            val userPwd = pwd.text.toString()

            if (user != null)  {
                if ((user.email == userEmail) && (user.pwd == userPwd)) {
                    email.setText("")
                    pwd.setText("")
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                }
                else
                    Toast.makeText(this, "${user?.name} is not registered", Toast.LENGTH_SHORT).show()
            } else if (userEmail.equals("root@gmail.com") && userPwd.equals("1234")) {
                email.setText("")
                pwd.setText("")
                startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            } else
                Toast.makeText(this, "Invalid user", Toast.LENGTH_SHORT).show()
        }
    }
}