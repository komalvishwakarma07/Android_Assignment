package com.example.module5.ques1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module5.adapter.TodoAdapter
import com.example.module5.adapter.TodoTaskAdapter
import com.example.module5.database.TodoDatabase
import com.example.module5.databinding.ActivityTodoBinding
import com.example.module5.model.ManageTask
import com.example.module5.model.Todo
import com.example.module5.que3.ManageActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.concurrent.thread

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    var db: TodoDatabase? = null
    private var todo: Todo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TodoDatabase.getIntance(this)

        todo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("todo", Todo::class.java)
        } else {
            intent.getParcelableExtra("todo")
        }



        binding.btnAdd.setOnClickListener {
            val title = binding.title.text.toString()
            val desc = binding.desc.text.toString()
            val date = binding.date.text.toString()
            updateRecord(title,desc,date)

            val intent = Intent(this, ManageActivity::class.java)
            intent.putExtra("todo", todo) // Pass the task data to ManageActivity
            startActivity(intent)
        }


        todo?.let {
            binding.btnAdd.text = "Update Task"
            binding.title.setText(it.name)
            binding.desc.setText(it.description)

        }
    }

    private fun updateRecord(title: String, desc: String, date: String) {

        var message=""
        thread(start = true) {
            var todoObject = Todo(
                name = title,
                description = desc,
                Date = date,
                id = if (todo != null) todo!!.id else 0,
                createdAt = if (todo != null) todo!!.createdAt else System.currentTimeMillis()
            )
            try {
                if (todo != null) {
                    //update
                    db!!.todoDao().updateTask(todoObject)
                    message = "Record updated successfully"
                } else {
                    //add
                    db!!.todoDao().insertTask(todoObject)
                    message = "Record added successfully"
                }

                runOnUiThread {
                    Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                    onBackPressedDispatcher.onBackPressed()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

}

