package com.example.module5

import com.example.module5.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("employee.php")
    fun create(
        @Field("flag") flag: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile") contact: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun getUsers(
        @Field("flag") flag: Int,
    ): Call<RegisterResponse>


    @FormUrlEncoded
    @POST("employee.php")
    fun userupdate(
        @Field("flag") flag: Int,
        @Field("id")id: String,
        @Field("name") name: String,
        @Field("mobile") contact: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("employee.php")
    fun Userdelete(
        @Field("flag") flag: Int,
        @Field("id")id: String,
    ): Call<RegisterResponse>

}