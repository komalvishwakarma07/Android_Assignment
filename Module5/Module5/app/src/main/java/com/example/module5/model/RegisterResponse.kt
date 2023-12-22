package com.example.module5.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    var status: String,
    var message: String,
    @SerializedName("employee")
    var user:MutableList<Employee>

)