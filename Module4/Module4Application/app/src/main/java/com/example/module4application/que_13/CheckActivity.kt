package com.example.module4application.que_13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.module4application.R
import com.example.module4application.databinding.ActivityCheckBinding

class CheckActivity : AppCompatActivity() {
    lateinit var binding:ActivityCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
               binding. textView.visibility = TextView.VISIBLE
            } else {
                binding.textView.visibility = TextView.GONE
            }
        }
    }
}