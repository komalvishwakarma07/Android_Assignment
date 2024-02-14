package com.example.module6application.ques9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.module6application.R
import com.example.module6application.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topanimation = AnimationUtils.loadAnimation(this, R.anim.topanimation)
        val bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottomanimation)

        binding.upperlogo.startAnimation(topanimation)
        binding.bottomlogo.startAnimation(bottomanimation)

        Handler().postDelayed({
            val intent = Intent(this, SplashhActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}
