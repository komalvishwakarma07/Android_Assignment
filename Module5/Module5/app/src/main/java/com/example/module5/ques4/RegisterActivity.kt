package com.example.module5.ques4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apiandroid.network.ApiClient
import com.example.module5.R
import com.example.module5.databinding.ActivityRegisterBinding
import com.example.module5.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            var name = binding.name.text.toString().trim()
            var email = binding.email.text.toString().trim()
            var contact = binding.mobile.text.toString().trim()

            createAccount(name, email, contact)
        }
    }
    private fun createAccount(name: String, email: String, contact: String) {
        ApiClient.init().create(flag = 1, name = name, email = email, contact = contact)
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>, response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {

                        var res = response.body()

                        if (res != null) {

                            Toast.makeText(applicationContext, "${res.message}", Toast.LENGTH_SHORT)
                                .show()

                            if (res.status == "success") {
                                startActivity(
                                    Intent(
                                        applicationContext,
                                        HomeActivity::class.java
                                    )
                                )
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }
            })
    }

}