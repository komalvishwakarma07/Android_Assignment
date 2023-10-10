package com.example.module4application.que_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.module4application.R

class CalculationActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        radioGroup = findViewById(R.id.radioGroup)
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            calculateResult()
        }
    }

    private fun calculateResult() {
        val number1 = etNumber1.text.toString().toDoubleOrNull()
        val number2 = etNumber2.text.toString().toDoubleOrNull()

        if (number1 == null || number2 == null) {
            tvResult.text = "Invalid input"
            return
        }

        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)

        val result = when (selectedRadioButton) {
            findViewById<RadioButton>(R.id.rbAdd) -> number1 + number2
            findViewById<RadioButton>(R.id.rbSubtract) -> number1 - number2
            findViewById<RadioButton>(R.id.rbMultiply) -> number1 * number2
            findViewById<RadioButton>(R.id.rbDivide) -> {
                if (number2 != 0.0) {
                    number1 / number2
                } else {
                    "Division by zero"
                }
            }
            else -> "Invalid operation"
        }

        tvResult.text = "Result: $result"
    }
}