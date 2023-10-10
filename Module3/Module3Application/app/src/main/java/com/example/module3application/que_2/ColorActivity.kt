package com.example.module3application.que_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.module3application.R
import com.example.module3application.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity() {
    lateinit var binding:ActivityColorBinding
    private var colorList= mutableListOf<Int>(R.color.black,R.color.white,R.color.green,R.color.orange,R.color.pink)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOne.setOnClickListener{
            binding.bgcolor.setBackgroundColor(ContextCompat.getColor(this,getRandomColor()))

        }


    }
    private fun getRandomColor():Int{
        return colorList.shuffled().last()
    }
}