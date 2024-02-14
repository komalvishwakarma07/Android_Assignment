package com.example.module6application.que6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.module6application.R
import com.example.module6application.databinding.ActivityRotateImageBinding

class RotateImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRotateImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRotateImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.rotation)
        binding.ivEarth.startAnimation(animation)

        binding.btnNextActivity.setOnClickListener {
            startActivity(Intent(this,BlinkActivity::class.java))
        }
    }
}