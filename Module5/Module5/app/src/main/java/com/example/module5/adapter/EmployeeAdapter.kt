package com.example.module5.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.databinding.ItemShowLayoutBinding
import com.example.module5.model.Employee

class EmployeeAdapter(var context: Context, var itemList : MutableList<Employee>):
    RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: ItemShowLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    var itemEditClickListener: ((position: Int, employee: Employee) -> Unit)? = null
    var SingleClickListener: ((position: Int, employee: Employee) -> Unit)? = null
    var ItemdeleteListener: ((position: Int,employee: Employee) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = ItemShowLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var note = itemList[position]
        holder.binding.name.text = note.name
        holder.binding.email.text = note.email
        holder.binding.mobile.text = note.contact

        holder.binding.cardview.setOnClickListener {
            SingleClickListener?.invoke(position,note)

        }
        holder.binding.edit.setOnClickListener {
            itemEditClickListener?.invoke(position, note
            )
        }
        holder.binding.delete.setOnClickListener {
            ItemdeleteListener?.invoke(position,note)
        }
    }
    fun showDeleteDialog(position: Int,employee: Employee) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete")
            .setMessage("Are you sure you want to delete?")
            .setPositiveButton("Delete") { dialog, which ->
                deleteItem(position, employee)
                Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show()
            }
            .create()
            .show()
    }

    private fun deleteItem(position: Int,employee: Employee) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateList(userList:MutableList<Employee>) {
        itemList.clear()
        itemList.addAll(userList)
        this.itemList=userList
        notifyDataSetChanged()

    }
}