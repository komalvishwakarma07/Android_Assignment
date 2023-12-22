package com.example.module5.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.module5.databinding.GridLayoutBinding
import com.example.module5.model.ManageTask
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class GridAdapter(private var context: Context, private var gridList: MutableList<ManageTask>) :
    BaseAdapter() {
    var itemEditClickListener: ((position: Int, task:ManageTask) -> Unit)? = null
    var itemDeleteClickListener: ((position: Int, task:ManageTask) -> Unit)? = null

    private lateinit var binding: GridLayoutBinding
    override fun getCount(): Int {
        return gridList.size
    }

    override fun getItem(position: Int): Any {
        return gridList[position]
    }

    override fun getItemId(position: Int): Long {
        return gridList[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = GridLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        var task = gridList[position]

        binding.name.text = "${task.name}"
        binding.desc.text = "${task.description}"
        binding.date.text = "${task.date}"
        binding.time.text = "${task.time}"
        binding.priority.text = "${task.priority}"

        // Sorting by date and time
        gridList.sortWith(compareBy { it.date + " " + it.time })

        when (task.priority){

           "HIGH" -> binding.root.setBackgroundColor(Color.RED)
            "AVERAGE" -> binding.root.setBackgroundColor(Color.BLUE)
           "LOW" -> binding.root.setBackgroundColor(Color.GREEN)
            else -> binding.root.setBackgroundColor(Color.WHITE) // Default color
        }

        binding.edit.setOnClickListener {
            itemEditClickListener?.invoke(position, task)
        }
        binding.delete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, task)
        }

        return binding.root
    }

    fun setItems(mutableList: MutableList<ManageTask>){
        this.gridList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int){
        gridList.removeAt(position)
        notifyDataSetChanged()
//        notifyItemRemoved(position)
    }
}

