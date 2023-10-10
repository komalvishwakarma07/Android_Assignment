package com.example.module4application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module4application.adapter.ItemAdapter
import com.example.module4application.databinding.ActivityMainBinding
import com.example.module4application.model.Item

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
        binding.recycleView.layoutManager= LinearLayoutManager(this)
        binding.recycleView.adapter = itemListAdapter

    }
    private fun preparData() {
        itemList.add(Item(id = 1,
            name = "1.Create an application to take input number from user and print its reverse number in TextView without button."
        ))
        itemList.add(Item(id = 2,
            name = "2.Create an application to input 2 numbers from user and all numbers between those 2 numbers in next activity "
        ))
        itemList.add(Item(id = 3,
            name = "3.Create an application with radio buttons (Add, Subtraction, Multiply, Division) EditText (number1, number2) and print result as per user choice from radio button in TextView "
        ))
        itemList.add(Item(id = 4,
            name = "4.Write a code to display login form when click on login button and registration form when click on registration button on single activity using fragment "
        ))
        itemList.add(Item(id = 5,
            name = "5.Create an application to load google url into webview also manage forward and backward redirect  "
        ))
        itemList.add(Item(id = 6,
            name = "6.In Previous Practical write code to check weather internet connection is available or not if "
        ))
        itemList.add(Item(id = 7,
            name = "7.no internet connection then display message accordingly  "
        ))
        itemList.add(Item(id = 8,
            name = "8.create an application to hide TextView when first button click and show when second button click "
        ))
        itemList.add(Item(id = 9,
            name = "9.Create an application to add TextView in TableLayout Programmatically "
        ))
        itemList.add(Item(id = 10,
            name = "10.create an application to open pdf using implicit intent "
        ))
        itemList.add(Item(id = 11,
            name = "11.create an application to increate font size when plus button click and decrease when minus button click "
        ))
        itemList.add(Item(id = 12,
            name = "12.create an application to display n edittext where n is number input by user"
        ))
        itemList.add(Item(id = 13,
            name = "13.Create an application to display Textview when checkbox is checked and hide "
        ))
        itemList.add(Item(id = 14,
            name = "14.Write a program to create one string array in string.xml file and that array show in listview "
        ))
        itemList.add(Item(id = 15,
            name = "15.Write a program in android display screen color which the Color will be select from the radio button. "
        ))
        itemList.add(Item(id = 16,
            name = "16.Write a program you have taken three seek bar controls. From three Seekbar which Seek bar value changed the background color of device will be changed. "
        ))
        itemList.add(Item(id = 17,
            name = "17.Create custom toolbar as per given below design "
        ))
        itemList.add(Item(id = 18,
            name = "18.Create toolbar with spinner and search functionality"
        ))

    }
}