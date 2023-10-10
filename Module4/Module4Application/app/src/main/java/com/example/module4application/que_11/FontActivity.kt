package com.example.module4application.que_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.module4application.R
import com.example.module4application.databinding.ActivityFontBinding

class FontActivity : AppCompatActivity() {
    lateinit var binding:ActivityFontBinding
//    private lateinit var textView: TextView
//    private lateinit var btnPlus: Button
//    private lateinit var btnMinus: Button
    private var fontSize = 18f // Initial font size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFontBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        textView = findViewById(R.id.textView)
//        btnPlus = findViewById(R.id.btnPlus)
//        btnMinus = findViewById(R.id.btnMinus)

       binding. textView.textSize = fontSize

       binding. btnPlus.setOnClickListener {
           fontSize += 2f
           binding.textView.textSize = fontSize
        }

       binding. btnMinus.setOnClickListener {
//           if (fontSize > 2f) {
               fontSize -= 2f
               binding.textView.textSize = fontSize

//           }
       }
    }

}