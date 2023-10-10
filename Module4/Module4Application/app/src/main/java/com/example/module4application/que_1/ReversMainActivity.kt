package com.example.module4application.que_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.module4application.R
import com.example.module4application.databinding.ActivityReversMainBinding

class ReversMainActivity : AppCompatActivity() {
    lateinit var binding:ActivityReversMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityReversMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.editTextNumber.addTextChangedListener { text ->
            val inputText = text.toString()
            val reversedText = inputText.reversed()
            binding.textViewResult.text = reversedText
        }
    }
}