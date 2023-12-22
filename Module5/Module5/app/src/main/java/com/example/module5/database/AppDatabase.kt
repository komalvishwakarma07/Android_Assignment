package com.example.noteapplication.database

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module5.model.Note
import com.example.noteapplication.dao.NoteDao


@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun noteDao(): NoteDao

    companion object{
        private var INSTANCE:AppDatabase?=null

        fun getIntance(context:Context):AppDatabase?{
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "notes.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}

