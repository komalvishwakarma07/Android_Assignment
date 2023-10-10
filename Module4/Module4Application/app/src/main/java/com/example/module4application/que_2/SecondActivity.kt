package com.example.module4application.que_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4application.R
import com.example.module4application.databinding.ActivityMainBinding
import com.example.module4application.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowNumbers.setOnClickListener {
            val firstNumber = binding.etFirstNumber.text.toString().toInt()
            val secondNumber =binding. etSecondNumber.text.toString().toInt()

            val intent = Intent(this, NumberActivity::class.java)
            intent.putExtra("firstNumber", firstNumber)
            intent.putExtra("secondNumber", secondNumber)
            startActivity(intent)
        }
    }
}