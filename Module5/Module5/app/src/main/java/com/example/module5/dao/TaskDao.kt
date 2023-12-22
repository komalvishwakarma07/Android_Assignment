package com.example.module5.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.module5.model.ManageTask
import com.example.module5.model.Todo

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task:ManageTask)

    @Query("select * from task_table ")
    fun getAllTask(): MutableList<ManageTask>

    @Delete
    fun deleteTask(task: ManageTask)

    @Update
    fun updateTask(task:ManageTask)
}