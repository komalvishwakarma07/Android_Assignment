package com.example.module6application.ques7

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.example.module6application.R
import com.example.module6application.databinding.ActivityZoomBinding

class ZoomActivity : AppCompatActivity() {
    private lateinit var binding:ActivityZoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Replace with your actual image resource
        binding.imageView.setImageResource(R.drawable.img_1)

        // Move Image Animation
        val moveAnimator = ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, 0f, 300f)
        moveAnimator.duration = 2000
        moveAnimator.interpolator = AccelerateDecelerateInterpolator()

        // Zoom In Animation
        val zoomInAnimation = ScaleAnimation(
            1.0f, 1.5f, 1.0f, 1.5f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        zoomInAnimation.duration = 2000
        zoomInAnimation.interpolator = AccelerateDecelerateInterpolator()

        // Zoom Out Animation
        val zoomOutAnimation = ScaleAnimation(
            1.5f, 1.0f, 1.5f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        zoomOutAnimation.duration = 2000
        zoomOutAnimation.interpolator = AccelerateDecelerateInterpolator()

        // Set click listeners
        binding.btnMove.setOnClickListener {
            moveAnimator.start()
        }

        binding.btnZoomIn.setOnClickListener {
            binding.imageView.startAnimation(zoomInAnimation)
        }

       binding. btnZoomOut.setOnClickListener {
            binding.imageView.startAnimation(zoomOutAnimation)
        }
    }
}