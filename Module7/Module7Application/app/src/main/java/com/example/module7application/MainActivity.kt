package com.example.module7application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module6application.adapter.ItemAdapter
import com.example.module6application.model.Item
import com.example.module7application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var itemListAdapter : ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preparData()

        itemListAdapter= ItemAdapter(this,itemList)
        binding.recycleView.layoutManager= LinearLayoutManager(this)
        binding.recycleView.adapter = itemListAdapter
    }

    private fun preparData() {
        itemList.add(Item(id = 1,
            name = "1 .set animation on splash screen with app logo "
        ))
        itemList.add(Item(id = 2,
            name = "2. Create an application to play song from raw resource folde"
        ))
        itemList.add(Item(id = 3,
            name = "3. Create an application to play song from mobile memory"
        ))
        itemList.add(Item(id = 4,
            name = "4. Create an application to play song from Server"
        ))
        itemList.add(Item(id = 5,
            name = "5. use WAKE LOCK when playing video play "
        ))
        itemList.add(Item(id = 6,
            name = "6. Create an application to convert text typed in edit text into speech "
        ))
        itemList.add(Item(id = 7,
            name = "7. Create an application for Wi-Fi on-off  "
        ))
    }
}