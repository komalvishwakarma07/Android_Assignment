package com.example.module6application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module6application.adapter.ItemAdapter
import com.example.module6application.databinding.ActivityMainBinding
import com.example.module6application.model.Item

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var itemListAdapter : ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preparData()

        itemListAdapter=ItemAdapter(this,itemList)
        binding.recycleView.layoutManager= LinearLayoutManager(this)
        binding.recycleView.adapter = itemListAdapter

    }

    private fun preparData() {
        itemList.add(Item(id = 1,
            name = "1 .pic selected from gallery or camera after login to application"
        ))
        itemList.add(Item(id = 2,
            name = "2. Create an application to display Google map with current location also give options to change mode in map"
        ))
        itemList.add(Item(id = 3,
            name = "3. Create an application to input address and display marker on that address"
        ))
        itemList.add(Item(id = 4,
            name = "4. Create an application to suggest places as user type with help of Place autocomplete"
        ))
        itemList.add(Item(id = 5,
            name = "5. service provide by Google "
        ))
        itemList.add(Item(id = 6,
            name = "6. Write a code to rotate image Write a code to blink image"
        ))
        itemList.add(Item(id = 7,
            name = "7. Write a code to move image from one place to another place Write a code to zoom in / out image using animation "
        ))
        itemList.add(Item(id = 8,
            name = "8. Write a code to show progress frame by frame animation"
        ))
        itemList.add(Item(id = 9,
            name = "9. set animation on splash screen with app logo  "
        ))
    }
}