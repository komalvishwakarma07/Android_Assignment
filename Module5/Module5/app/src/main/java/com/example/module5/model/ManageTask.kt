package com.example.module5.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Locale

@Parcelize
@Entity(tableName = "task_table")
data class ManageTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Provide a default value for auto-generating IDs
    val name: String,
    val description: String,
    val date: String,
    val time: String,
    val priority: String,
    @ColumnInfo(name = "create_At")
    var createdAt: Long = System.currentTimeMillis()
):Parcelable
