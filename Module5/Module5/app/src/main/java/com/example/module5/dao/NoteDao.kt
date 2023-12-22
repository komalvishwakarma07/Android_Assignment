package com.example.noteapplication.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.module5.model.Note


@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Query("select * from note_table ")
    fun getAllNote(): MutableList<Note>

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)
}

