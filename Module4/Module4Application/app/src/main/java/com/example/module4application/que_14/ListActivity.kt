package com.example.module4application.que_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.module4application.R
import com.example.module4application.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    lateinit var binding:ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var item=resources.getStringArray(R.array.my_array)
        val adapterarray=ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
        binding.listView.adapter=adapterarray
    }
}