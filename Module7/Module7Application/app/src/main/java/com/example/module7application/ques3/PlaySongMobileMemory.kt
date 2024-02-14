package com.example.module7application.ques3

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import com.example.module7application.databinding.ActivityPlaySongMobileMemoryBinding
import java.util.Timer
import java.util.TimerTask

class PlaySongMobileMemory : AppCompatActivity() {
    private lateinit var binding:ActivityPlaySongMobileMemoryBinding
//    private  var mediaPlayer: MediaPlayer?=null
    private var mediaPlayer: MediaPlayer? = MediaPlayer()
    private lateinit var progressBar: ProgressBar
    private var isplay=false

    private val picksonglauncher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        if (result.resultCode==Activity.RESULT_OK){
            result.data?.data?.let { uri ->
                playsong(uri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding=ActivityPlaySongMobileMemoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressBar=binding.progressBar2

        mediaPlayer = MediaPlayer()

        setupMediaPlayer()
        setupClickListener()


        //update progress bar while playing
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (isplay) {
                        progressBar.progress = mediaPlayer!!.currentPosition
                    }
                }
            }

        }, 0, 1000)


        binding.progressBar2.setOnTouchListener { v, event ->
            onProgressBarClick(event)
            true
        }
        showStopImage()
        binding.play.setOnClickListener {
            selectSong()
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
            }else{
                mediaPlayer?.start()
            }
            showStopImage()
        }
    }

    private fun setupClickListener() {
        binding.play.setOnClickListener { onPlayButtonClick() }
        binding.stop.setOnClickListener { onStopButtonClick() }
    }

    private fun onStopButtonClick() {
        mediaPlayer!!.pause()
        showPlayImage()
        isplay=false
    }

    private fun onPlayButtonClick() {
        if(isplay){
            mediaPlayer!!.pause()
            showPlayImage()
        }else{
            mediaPlayer!!.start()
            showStopImage()

            isplay = !isplay
        }
    }

    private fun setupMediaPlayer() {
        mediaPlayer?.setOnCompletionListener {
            // Reset the mediaplayer when playback is complete
            isplay = false
            showPlayImage()
            mediaPlayer?.seekTo(0)
            progressBar.progress = 0
        }
    }

    private fun onProgressBarClick(event: MotionEvent?) {
        val newPosition = (event!!.x / progressBar.width) * progressBar.max
        mediaPlayer!!.seekTo(newPosition.toInt())
        progressBar.progress = newPosition.toInt()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer!!.release()
    }

    private fun showStopImage() {
        binding.play.visibility = View.GONE
        binding.stop.visibility=View.VISIBLE
    }

    private fun showPlayImage() {
        binding.play.visibility = View.VISIBLE
        binding.stop.visibility= View.GONE
    }

    private fun selectSong() {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "audio/*"
            }
            picksonglauncher.launch(intent)
    }
    private fun playsong(uri: Uri) {
        mediaPlayer?.release()

        mediaPlayer=MediaPlayer().apply {
            setDataSource(this@PlaySongMobileMemory,uri)
            prepare()
            start()
//            this@PlaySongMobileMemory.isplay=true
            isplay=true
            showPlayImage()
           seekTo(0)
//            mediaPlayer?.seekTo(0)
            binding.progressBar2.progress=0
        }
        binding.play.setOnClickListener {
            if (mediaPlayer?.isPlaying==true) {
                mediaPlayer?.pause()
            }else{
                mediaPlayer?.start()
            }
        }
        showStopImage()
        mediaPlayer!!.setOnPreparedListener {
            binding.progressBar2.max=mediaPlayer!!.duration
            binding.progressBar2.progress=0
        }
    }


}