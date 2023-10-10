package com.example.module4application.que_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentvalidation.fragment.RagisterFragment
import com.example.module4application.R

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        var fragment=RagisterFragment()
        var manager=supportFragmentManager
        var transaction=manager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()

    }
}