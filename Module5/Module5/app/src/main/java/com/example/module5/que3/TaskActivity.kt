package com.example.module5.que3

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.module5.R
import com.example.module5.database.TaskDatabase
import com.example.module5.databinding.ActivityTaskBinding
import com.example.module5.model.ManageTask
import com.example.module5.model.Note
import com.example.module5.model.Priority
import com.example.noteapplication.database.AppDatabase
import kotlin.concurrent.thread

class TaskActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTaskBinding
    private var taskList = mutableListOf<Priority>()
    var db: TaskDatabase? = null
    private var task:ManageTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabase.getIntance(this)

        task = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("task", ManageTask::class.java)
        } else {
            intent.getParcelableExtra("task")
        }

        task?.let {
            binding.btnAdd.text = "Update Task"
            binding.namee.setText(it.name)
            binding.desc.setText(it.description)
            binding.date.setText(it.date)
            binding.time.setText(it.time)
            binding.autoPriority.setText(it.priority)
        }



        getpriority()
        binding.btnAdd.setOnClickListener {
            val name = binding.namee.text.toString()
            val desc = binding.desc.text.toString()
            val date = binding.date.text.toString()
            val time = binding.time.text.toString()
            val priority=binding.autoPriority.text.toString()
            updateRecord(name,desc,date,time,priority)

            val intent = Intent(this@TaskActivity, ManageActivity::class.java)
            intent.putExtra("taskData", task) // Pass the task data to ManageActivity
            startActivity(intent)
        }
    }

    private fun updateRecord(name: String, desc: String, date: String, time: String, priority: String) {
        thread(start = true) {
            val taskObject = ManageTask(
                name = name,
                description = desc,
                date = date,
                time = time,
                priority = priority,
                id = task?.id ?: 0,
                createdAt = task?.createdAt ?: System.currentTimeMillis()
            )

            try {
                if (task != null) {
                    // Update existing task
                    db?.taskDao()?.updateTask(taskObject)
                } else {
                    // Insert new task
                    db?.taskDao()?.insertTask(taskObject)
                }

                runOnUiThread {
                    val message = if (task != null) {
                        "Record updated successfully"
                    } else {
                        "Record added successfully"
                    }
                    Toast.makeText(this@TaskActivity, message, Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@TaskActivity, ManageActivity::class.java)
                    startActivity(intent)
//                    onBackPressedDispatcher.onBackPressed()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    private fun PreparData(){
        taskList.add(Priority(id = 1, name = "HIGH"))
        taskList.add(Priority(id = 2, name = "AVERAGE"))
        taskList.add(Priority(id = 3, name = "LOW"))
    }

    private fun getpriority() {
        PreparData()
        val priorityNames = taskList.map { it.name }

        val priorityAdapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_dropdown_item,
            priorityNames
        )

        binding.autoPriority.setAdapter(priorityAdapter)

        binding.autoPriority.onItemClickListener = object :
            AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Handle item click if needed
            }
        }
    }
}