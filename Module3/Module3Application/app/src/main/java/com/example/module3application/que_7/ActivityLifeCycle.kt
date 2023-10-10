package com.example.module3application.que_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module3application.R

class ActivityLifeCycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }
}