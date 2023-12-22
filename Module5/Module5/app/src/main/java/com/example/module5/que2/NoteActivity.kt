package com.example.module5.que2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module5.adapter.NoteAdapter
import com.example.module5.databinding.ActivityNoteBinding
import com.example.module5.model.Note
import com.example.noteapplication.database.AppDatabase
import kotlin.concurrent.thread

class NoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNoteBinding
    private var notesList = mutableListOf<Note>()
    private lateinit var noteAdapter : NoteAdapter
    var db: AppDatabase? = null
    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteAdapter=NoteAdapter(this,notesList)
        binding.rv.layoutManager= LinearLayoutManager(this)
        binding.rv.adapter = noteAdapter

        db = AppDatabase.getIntance(this)

        note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("note", Note::class.java)
        } else {
            intent.getParcelableExtra("note")
        }

        note?.let {
            binding.btnAdd.text = "Update Note"
            binding.title.setText(it.Title)
            binding.msg.setText(it.msg)
        }

        binding.btnAdd.setOnClickListener {
            val title = binding.title.text.toString()
            val message = binding.msg.text.toString()
            updateRecord(title,message)
        }
        readNoteList()
        noteAdapter.itemEditClickListener = { position, note ->
            var intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("note", note)
            startActivity(intent)
        }
        noteAdapter.itemDeleteClickListener = { position, note ->
            try {
                AppDatabase.getIntance(this)?.noteDao()!!.deleteNote(note)
                Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
                noteAdapter.deleteItem(position)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
    private fun readNoteList() {
        notesList = AppDatabase.getIntance(this)?.noteDao()!!.getAllNote()
        noteAdapter.setItems(notesList)
    }
    override fun onResume() {
        super.onResume()
        readNoteList()
    }

    private fun updateRecord(title: String, mesg: String) {

        var message=""
        thread(start = true) {
            var noteObject = Note(
                Title = title,
                msg = mesg,
                id = if (note != null) note!!.id else 0,
                createdAt = if (note != null) note!!.createdAt else System.currentTimeMillis()
            )
            try {
                if (note != null) {
                    //update
                    db!!.noteDao().updateNote(noteObject)
                    message = "Record updated successfully"
                } else {
                    //add
                    db!!.noteDao().insertNote(noteObject)
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