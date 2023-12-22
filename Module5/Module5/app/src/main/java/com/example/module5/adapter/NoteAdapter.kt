package com.example.module5.adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.databinding.AddItemLayoutBinding
import com.example.module5.model.Note
class NoteAdapter(var context: Context, var noteList : MutableList<Note>):
    RecyclerView.Adapter<NoteAdapter.MyViewHolder>(){
    class MyViewHolder(var binding: AddItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    var itemEditClickListener: ((position: Int, note: Note) -> Unit)? = null
    var itemDeleteClickListener: ((position: Int,  note: Note) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding=AddItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return noteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var note = noteList[position]
        holder.binding.title.text=note.Title
        holder.binding.message.text=note.msg

        holder.binding.delete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, note)
        }
        holder.binding.edit.setOnClickListener {
            itemEditClickListener?.invoke(position, note)
        }
    }
    fun setItems(mutableList: MutableList<Note>) {
        this.noteList = mutableList
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int) {
        noteList.removeAt(position)
        notifyItemRemoved(position)
    }
}