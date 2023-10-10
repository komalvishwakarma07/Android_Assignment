package com.example.module3application.que_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.module3application.R

class RegisterPage : AppCompatActivity() {
    val btnsign:TextView
        get() = findViewById(R.id.btn_register)

//    val btnlogin:TextView
//        get() = findViewById(R.id.btn_login)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        btnsign.setOnClickListener{
            var intent=Intent(this,LoginPage::class.java)
            startActivity(intent)
        }

    }
}