package com.example.module6application.que6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.module6application.R
import com.example.module6application.databinding.ActivityBlinkBinding

class BlinkActivity : AppCompatActivity() {
    private lateinit var binding:ActivityBlinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBlinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var animation : Animation = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.imageView.startAnimation(animation)

    }
}