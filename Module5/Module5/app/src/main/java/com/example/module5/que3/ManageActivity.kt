package com.example.module5.que3

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.module5.adapter.GridAdapter
import com.example.module5.database.TaskDatabase
import com.example.module5.databinding.ActivityManageBinding
import com.example.module5.model.ManageTask

class ManageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageBinding

    private lateinit var gridAdapter: GridAdapter
    private  var tasks= mutableListOf<ManageTask>()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        gridAdapter = GridAdapter(this, tasks)
        binding.taskGridView.adapter = gridAdapter
        readManagetask()

        binding.btnAddTask.setOnClickListener {
            startActivity(Intent(this
            ,TaskActivity::class.java))
        }

        gridAdapter.itemEditClickListener = { position, task ->
            var intent = Intent(this, TaskActivity::class.java)
            intent.putExtra("task", task)
            tasks.sortBy { it.date + it.time }
            startActivity(intent)

        }
        gridAdapter.itemDeleteClickListener = { position, task ->
            showAlertDialog(position,task)
        }
    }
    private fun readManagetask() {
        tasks = TaskDatabase.getIntance(this)?.taskDao()!!.getAllTask()
        gridAdapter.setItems(tasks)
    }
    override fun onResume() {
        super.onResume()
        readManagetask()
    }
    private fun showAlertDialog(positin:Int,task:ManageTask) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Delete")
        builder.setMessage("are you sure you want to delete?")
        builder.setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, which ->
            TaskDatabase.getIntance(this)?.taskDao()?.deleteTask(task)
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
            gridAdapter.deleteItem(positin)
        })
        builder.setNegativeButton("Cancle", DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "cancle", Toast.LENGTH_SHORT).show()
        })
        var dialog = builder.create()
        dialog.show()
    }

}