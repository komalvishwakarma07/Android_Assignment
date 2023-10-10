package com.example.module4application.que_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.module4application.R

class NumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        val tvNumbers = findViewById<TextView>(R.id.tvNumbers)

        val firstNumber = intent.getIntExtra("firstNumber", 0)
        val secondNumber = intent.getIntExtra("secondNumber", 0)

        val numbersBetween = calculateNumbersBetween(firstNumber, secondNumber)
        tvNumbers.text = numbersBetween.joinToString(", ")
    }

    private fun calculateNumbersBetween(start: Int, end: Int): List<Int> {
        return if (start <= end) {
            (start..end).toList()
        } else {
            (start downTo end).toList()
        }
    }

    
}