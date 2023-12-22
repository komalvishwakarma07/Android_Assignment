package com.example.module5.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.module5.model.Todo

@Dao
interface TodoDao {
    @Insert
    fun insertTask(todo: Todo)

    @Query("select * from todo_table ")
    fun getAllTask(): MutableList<Todo>

    @Delete
    fun deleteTask(todo: Todo)

    @Update
    fun updateTask(todo: Todo)
}