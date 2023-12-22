package com.example.module4application.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module4application.model.Item
import com.example.module5.databinding.ItemLayoutBinding
import com.example.module5.model.Note
import com.example.module5.que2.NoteActivity
import com.example.module5.que3.ManageActivity
import com.example.module5.que3.TaskActivity
import com.example.module5.que6.ImageSelectActivity
import com.example.module5.ques1.TodoActivity
import com.example.module5.ques1.TodoTaskActivity
import com.example.module5.ques4.RegisterActivity


class ItemAdapter(var context: Context, var itemList: MutableList<Item>) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    class MyViewHolder(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = itemList[position]
        holder.binding.name.text = item.name

        holder.binding.cdView.setOnClickListener {
            when (item.id) {
                1 -> {
                    var intent = Intent(context, TodoTaskActivity::class.java)
                    context.startActivity(intent)

                }

                2 -> {
                    var intent = Intent(context, NoteActivity::class.java)
                    context.startActivity(intent)

                }

                3 -> {
                    var intent = Intent(context, ManageActivity::class.java)
                    context.startActivity(intent)

                }

                4 -> {
                    var intent = Intent(context, RegisterActivity::class.java)
                    context.startActivity(intent)

                }

                5 -> {
                    var intent = Intent(context, RegisterActivity::class.java)
                    context.startActivity(intent)

                }

                6 -> {
                    var intent = Intent(context, ImageSelectActivity::class.java)
                    context.startActivity(intent)

                }
            }
        }

    }
}
