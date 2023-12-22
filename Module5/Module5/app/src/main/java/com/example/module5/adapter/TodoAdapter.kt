package com.example.module5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.databinding.TodoItemBinding
import com.example.module5.model.Note
import com.example.module5.model.Todo

class TodoAdapter(var context: Context, var todoList : MutableList<Todo>):
    RecyclerView.Adapter<TodoAdapter.MyViewHolder>(){
    class MyViewHolder(var binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)


    var itemEditClickListener: ((position: Int, todo:Todo) -> Unit)? = null
    var itemDeleteClickListener: ((position: Int,  todo:Todo) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding=TodoItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var todo = todoList[position]
        holder.binding.textTaskTitle.text=todo.name
        holder.binding.textTaskDescription.text=todo.description

        holder.binding.edit.setOnClickListener {
            itemEditClickListener?.invoke(position, todo)
        }
        holder.binding.delete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, todo)
        }
    }

    fun setItems(mutableList: MutableList<Todo>) {
        this.todoList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int) {
        todoList.removeAt(position)
        notifyItemRemoved(position)
    }
}