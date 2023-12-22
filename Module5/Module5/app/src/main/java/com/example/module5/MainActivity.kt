package com.example.module5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module4application.adapter.ItemAdapter
import com.example.module4application.model.Item
import com.example.module5.databinding.ActivityMainBinding

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
            name = "1.Create an application of todo app using SQLite with function lite to create list of upcoming task, completed task, remove task, update task in daily activity. "
        ))
        itemList.add(Item(id = 2,
            name = "2.Create a Sticky Notes app with proper customization which can insert,view,update,delete using SQLite database "
        ))
        itemList.add(Item(id = 3,
            name = "3. To create task management application for adding, updating, deleting the task and show the tasks in the listview or gridview. Task have name, description, date, time, priority. Sort the task by the date and time wise. If task is due then automatically show as blue color. It will search the tasks by date wise. If high priority then show as red color, average priority as blue color, low priority as green color. Select specified item an open context menu to select “Complete the Task then this task "
        ))
        itemList.add(Item(id = 4,
            name = "4.Create an application in which employee can login and register with MySQL database  "
        ))
        itemList.add(Item(id = 5,
            name = "5.In previous application after logging employee can insert, update and delete project details Create an application to select employee profile page in which employee can upload profile "
        ))
        itemList.add(Item(id = 6,
            name = "6.pic selected from gallery or camera after login to application  "
        ))

    }
}