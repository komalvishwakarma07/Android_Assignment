package com.example.module5.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.module5.dao.TaskDao
import com.example.module5.model.ManageTask

@Database(entities = [ManageTask::class], version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun taskDao(): TaskDao

    companion object{
        private var INSTANCE: TaskDatabase?=null

        fun getIntance(context: Context): TaskDatabase?{
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE =
                        Room.databaseBuilder(context, TaskDatabase::class.java, "tasks.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}