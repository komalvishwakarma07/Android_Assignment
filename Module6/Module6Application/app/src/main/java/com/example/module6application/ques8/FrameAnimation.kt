package com.example.module6application.ques8

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module6application.R
import com.example.module6application.databinding.ActivityFrameAnimationBinding

class FrameAnimation : AppCompatActivity() {
    private lateinit var binding:ActivityFrameAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFrameAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ad = AnimationDrawable()
        var frame1 = resources.getDrawable(R.drawable.img,null)
        var frame2 = resources.getDrawable(R.drawable.splash_bg,null)

        ad.addFrame(frame1,200)
        ad.addFrame(frame2,300)

        binding.imageView.background = ad

        binding.button.setOnClickListener {
            ad.start()
        }
        binding.button2.setOnClickListener {
            ad.stop()
        }
    }
}