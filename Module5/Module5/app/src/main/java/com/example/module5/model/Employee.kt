package com.example.module5.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee (
    var id:String,
    var name:String,
    var email:String,
    @SerializedName("mobile")
    var contact:String,
): Parcelable