package com.example.module3application.que_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentapplication.FirstFragment
import com.example.module3application.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var fragment= FirstFragment()

        var manager=supportFragmentManager
        var transaction=manager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()

    }
}