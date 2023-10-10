package com.example.module3application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module3application.adapter.ItemAdapter
import com.example.module3application.databinding.ActivityMainBinding
import com.example.module3application.model.Item

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
   private lateinit var itemListAdapter : ItemAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preparData()
       itemListAdapter=ItemAdapter(this,itemList)
        binding.recycleView.layoutManager=LinearLayoutManager(this)
        binding.recycleView.adapter = itemListAdapter

    }

    private fun preparData() {
        itemList.add(Item(id = 1,
            name = "1.Create “hello world” application "
        ))
        itemList.add(Item(id = 2,
            name = "2.Change screen background color on different button click event "
        ))
        itemList.add(Item(id = 3,
            name = "3.Navigate between one screen to another screen "
        ))
        itemList.add(Item(id = 4,
            name = "4.Pass data from one screen to second screen  "
        ))
        itemList.add(Item(id = 5,
            name = "5.Design login and registration screen "
        ))
        itemList.add(Item(id = 6,
            name = "6.What is R.java file "
        ))
        itemList.add(Item(id = 7,
            name = "7.What is activity and activity lifecycle   "
        ))
        itemList.add(Item(id = 8,
            name = "8.What is fragment and fragment lifecycle"
        ))
        itemList.add(Item(id = 9,
            name = "9.Activity to fragment and fragment to activity "
        ))

    }
}