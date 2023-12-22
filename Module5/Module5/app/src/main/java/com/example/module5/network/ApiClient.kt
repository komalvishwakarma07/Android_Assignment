package com.example.apiandroid.network

import com.example.module5.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        private var retrofit: Retrofit? = null
        fun init(): ApiService {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.20.139/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiService::class.java)
        }
    }
}