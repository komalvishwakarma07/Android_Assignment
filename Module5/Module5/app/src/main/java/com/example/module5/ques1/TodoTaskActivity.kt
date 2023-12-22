package com.example.module5.ques1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module5.adapter.TodoAdapter
import com.example.module5.adapter.TodoTaskAdapter
import com.example.module5.database.TaskDatabase
import com.example.module5.database.TodoDatabase
import com.example.module5.databinding.ActivityTodoTaskBinding
import com.example.module5.model.Todo
import com.example.module5.que3.TaskActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TodoTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoTaskBinding
    private var todoList = mutableListOf<Todo>()
    private lateinit var todotaskAdapter : TodoTaskAdapter
    private lateinit var todoAdapter : TodoAdapter

    var db: TodoDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTodoTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = TodoDatabase.getIntance(this)

        todotaskAdapter= TodoTaskAdapter(this,todoList)
        binding.rv1.layoutManager= LinearLayoutManager(this)
        binding.rv1.adapter = todotaskAdapter

        todoAdapter= TodoAdapter(this,todoList)
        binding.rv.layoutManager= LinearLayoutManager(this)
        binding.rv.adapter = todoAdapter

        readupcomming()
        readcompletetask()
        binding.btnAddTask.setOnClickListener {
            startActivity(Intent(this,TodoActivity::class.java))
        }
        todotaskAdapter.itemEditClickListener = { position, todo ->
            var intent = Intent(this, TodoActivity::class.java)
            intent.putExtra("todo", todo)
            startActivity(intent)
        }
        todoAdapter.itemEditClickListener = { position, todo ->
            var intent = Intent(this, TodoActivity::class.java)
            intent.putExtra("todo", todo)
            startActivity(intent)
        }
        todotaskAdapter.itemDeleteClickListener = { position, todo ->
            showAlertDialog(position,todo)
        }
        todoAdapter.itemDeleteClickListener = { position, todo ->
            showAlertDialog(position,todo)
        }
    }

    private fun readupcomming() {
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().time)
        todoList = TodoDatabase.getIntance(this)?.todoDao()!!.getAllTask()
            .filter { todo ->  todo.Date >= currentDate }
            .toMutableList()

        todoAdapter.setItems(todoList)
    }

    private fun readcompletetask() {
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().time)
        todoList = TodoDatabase.getIntance(this)?.todoDao()!!.getAllTask()
            .filter { todo ->  todo.Date <= currentDate }
            .toMutableList()
        todotaskAdapter.setItems(todoList)
    }

    override fun onResume() {
        super.onResume()
        readupcomming()
        readcompletetask()
    }
    private fun showAlertDialog(position:Int, todo: Todo) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("are you sure you want to delete?")
        builder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, which ->
            TodoDatabase.getIntance(this)?.todoDao()?.deleteTask(todo
            )
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
            todotaskAdapter.deleteItem(position)
            todoAdapter.deleteItem(position)
        })
        builder.setNegativeButton("Cancle", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "cancle", Toast.LENGTH_SHORT).show()
        })
        var dialog = builder.create()
        dialog.show()
    }

}