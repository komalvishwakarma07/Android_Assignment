package com.example.module4application.que_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.example.module4application.R
import com.example.module4application.databinding.ActivityNnumberBinding

class NnumberActivity : AppCompatActivity() {
     lateinit var binding:ActivityNnumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding=ActivityNnumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generateFieldsButton.setOnClickListener {

            val numberOfFields = binding.numberOfFieldsEditText.text.toString().toIntOrNull()


           binding. editTextContainer.removeAllViews()

            if (numberOfFields != null && numberOfFields > 0) {
                for (i in 1..numberOfFields) {
                    val editText = EditText(this)
                    editText.hint = "Field $i"
                    binding.editTextContainer.addView(editText)
                }
            }
        }
    }






}

