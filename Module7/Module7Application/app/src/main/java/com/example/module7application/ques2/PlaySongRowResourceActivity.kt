package com.example.module7application.ques2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ProgressBar
import com.example.module7application.R
import com.example.module7application.databinding.ActivityPlaySongRowResourceBinding
import java.util.Timer
import java.util.TimerTask

class PlaySongRowResourceActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPlaySongRowResourceBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var progressBar: ProgressBar
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaySongRowResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn3.setOnClickListener {
            startActivity(Intent(this,PlaySongRowResourceActivity::class.java))
        }

        mediaPlayer=MediaPlayer.create(this,R.raw.khudajane)
        progressBar=binding.progressBar2

        setupMediaPlayer()
        setupClickListener()



    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
    private fun showPlayImage(){
        binding.play.visibility = View.VISIBLE
        binding.stop.visibility=View.GONE
    }

    private fun showStopImage(){
        binding.play.visibility = View.GONE
        binding.stop.visibility=View.VISIBLE
    }
    private fun setupMediaPlayer() {
        mediaPlayer.setOnCompletionListener {
            //Reset the mediaplayer when playback is complete
            isPlaying = false
            showPlayImage()
            mediaPlayer.seekTo(0)
            progressBar.progress = 0
        }

        //update progress bar as the media is being playes
        mediaPlayer.setOnPreparedListener {
            progressBar.max = mediaPlayer.duration
            progressBar.progress = 0
        }

        //update progress bar while playing
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (isPlaying) {
                        progressBar.progress = mediaPlayer.currentPosition
                    }
                }
            }

        }, 0, 1000)
        binding.progressBar2.setOnTouchListener { v, event ->
            onProgressBarClick(event)
            true
        }
    }

    private fun onProgressBarClick(event: MotionEvent?) {
        val newPosition = (event!!.x / progressBar.width) * progressBar.max
        mediaPlayer.seekTo(newPosition.toInt())
        progressBar.progress = newPosition.toInt()

    }
    private fun setupClickListener() {
        binding.play.setOnClickListener { onPlayButtonClick() }
        binding.stop.setOnClickListener { onStopButtonClick() }
    }

    private fun onStopButtonClick() {
        mediaPlayer.pause()
        showPlayImage()
        isPlaying=false
    }

    private fun onPlayButtonClick() {
        if(isPlaying){
            mediaPlayer.pause()
            showPlayImage()
        }else{
            mediaPlayer.start()
            showStopImage()

            isPlaying = !isPlaying
        }
    }

}
