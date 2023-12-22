package com.example.module5.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var Title:String,
    var msg:String,
    @ColumnInfo(name = "creat_At")
    var createdAt: Long = System.currentTimeMillis()
): Parcelable



