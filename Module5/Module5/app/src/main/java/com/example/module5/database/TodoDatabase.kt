package com.example.module5.database

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module5.dao.TodoDao
import com.example.module5.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {

                private var INSTANCE: TodoDatabase? = null

                fun getIntance(context: Context): TodoDatabase?{
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE =
                        Room.databaseBuilder(context, TodoDatabase::class.java, "todo.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}