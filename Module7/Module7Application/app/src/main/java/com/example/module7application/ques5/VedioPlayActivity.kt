package com.example.module7application.ques5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.module7application.R
import com.example.module7application.databinding.ActivityVedioPlayBinding

class VedioPlayActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVedioPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVedioPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vediopath="android.resource://com.example.module7application/" + R.raw.vedio
        binding.video.setVideoPath(vediopath)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.video)

        binding.btnplay.setOnClickListener {
            if (binding.video.isPlaying){
                binding.video.pause()
                binding.btnplay.text = "play"
            }else{
                binding.video.start()
                binding.btnplay.text="pause"
            }
        }
    }
}