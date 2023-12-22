package com.example.module5.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Long=0,
    var name:String,
    var Date: String,
    val description: String,
    @ColumnInfo(name = "creat_At")
    var createdAt: Long = System.currentTimeMillis()
) : Parcelable
