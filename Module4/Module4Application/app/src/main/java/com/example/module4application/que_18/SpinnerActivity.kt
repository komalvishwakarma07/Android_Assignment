package com.example.module4application.que_18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.module4application.R
import com.example.module4application.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {

    lateinit var binding:ActivitySpinnerBinding
    private var course = setOf<String>("BCA","MCA","BSC","Bcom")
    private lateinit var courseAdapter:ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        courseAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,course.toList())
        binding.spinner.adapter=  courseAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var  courseset=course.toList()[p2]
                Toast.makeText(applicationContext, "$courseset", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
}