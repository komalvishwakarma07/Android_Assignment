package com.example.module3application.que_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module3application.R
import com.example.module3application.databinding.ActivityMainBinding
import com.example.module3application.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            val fragment = ActivityFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()

        }


    }
}