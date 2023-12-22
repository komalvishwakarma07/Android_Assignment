package com.example.module5.ques4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apiandroid.PrefManager
import com.example.apiandroid.network.ApiClient
import com.example.module5.R
import com.example.module5.databinding.ActivityLoginBinding
import com.example.module5.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.res.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        binding.btnLogin.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            var email = binding.email.text.toString().trim()
            var password = binding.password.text.toString().trim()



            createAccount( email, password)

        }
    }
    private fun createAccount(email: String, password: String) {
        ApiClient.init().create(flag = 6, email = email, contact = "", name = "")
            .enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>, response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        if (password == "123456") {
                            val manager = PrefManager(applicationContext)
                            manager.Updatelogin(true)
                            val intent = Intent(applicationContext, HomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(applicationContext, "Invalid password", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }
            })
    }
}