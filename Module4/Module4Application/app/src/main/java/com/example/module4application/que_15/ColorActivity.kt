package com.example.module4application.que_15

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4application.R
import com.example.module4application.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity() {

    lateinit var binding:ActivityColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedColor = when (checkedId) {
                R.id.radioRed -> Color.RED
                R.id.radioGreen -> Color.GREEN
                R.id.radioBlue -> Color.BLUE
                else -> Color.WHITE
            }
            binding.colorView.setBackgroundColor(selectedColor)
        }
    }
}