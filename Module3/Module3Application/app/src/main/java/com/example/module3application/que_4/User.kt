package com.example.module3application.que_4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        var name : String,
        var email:String,
        var age : Int,
        var address:String=""
):Parcelable
