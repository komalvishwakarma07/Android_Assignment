package com.example.module7application.ques4

import android.app.Activity
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.module7application.R
import com.example.module7application.databinding.ActivityPlaySongFromServerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.Timer
import java.util.TimerTask

class PlaySongFromServerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaySongFromServerBinding
    private  var mediaPlayer: MediaPlayer?=null
    private lateinit var progressBar: ProgressBar
    private var isplay=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlaySongFromServerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {
            playAudio()
        }
        binding.btnpause.setOnClickListener {
            pauseAudio()
        }
//
//        progressBar=binding.progressBar
//
//        mediaPlayer = MediaPlayer()
//
//        setupMediaPlayer()
//        setupClickListener()

    }

//    private fun onProgressBarClick(event: MotionEvent?) {
//        val newPosition = (event!!.x / progressBar.width) * progressBar.max
//        mediaPlayer.seekTo(newPosition.toInt())
//        progressBar.progress = newPosition.toInt()
//    }

//    private fun showStopImage() {
//        binding.btnPlay.visibility = View.GONE
//        binding.btnPause.visibility=View.VISIBLE
//    }
//
//    private fun setupClickListener() {
//        binding.btnPlay.setOnClickListener { onPlayButtonClick() }
//        binding.btnPause.setOnClickListener { onStopButtonClick() }
//    }

    private fun onStopButtonClick() {
        mediaPlayer!!.pause()
        showPlayImage()
        isplay=false
    }

    private fun showPlayImage() {
        binding.btnPlay.visibility = View.VISIBLE
        binding.btnpause.visibility= View.GONE
    }

//    private fun onPlayButtonClick() {
//        if(isplay){
//            mediaPlayer!!.pause()
//            showPlayImage()
//        }else{
//            mediaPlayer!!.start()
//            showStopImage()
//
//            isplay = !isplay
//        }
//    }

//    private fun setupMediaPlayer() {
//            mediaPlayer.setOnCompletionListener {
//                //Reset the mediaplayer when playback is complete
//                isplay = false
//                showPlayImage()
//                mediaPlayer.seekTo(0)
//                progressBar.progress = 0
//            }
//
//            //update progress bar as the media is being playes
//            mediaPlayer.setOnPreparedListener {
//                progressBar.max = mediaPlayer.duration
//                progressBar.progress = 0
//            }
//
//            //update progress bar while playing
//            Timer().scheduleAtFixedRate(object : TimerTask() {
//                override fun run() {
//                    runOnUiThread {
//                        if (isplay) {
//                            progressBar.progress = mediaPlayer.currentPosition
//                        }
//                    }
//                }
//
//            }, 0, 1000)
//            binding.progressBar.setOnTouchListener { v, event ->
//                onProgressBarClick(event)
//                true
//            }
//    }

    private fun pauseAudio() {
        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.reset()
            mediaPlayer!!.release()
        } else {
            Toast.makeText(this, "Audio has not played", Toast.LENGTH_SHORT).show()
        }
    }

    private fun playAudio() {
        val audiourl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
//        val audiourl = "https://www.jiosaavn.com/album/ram-aayenge/vtg8blOjz2A_"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
//        mediaPlayer.setDataSource(audiourl)
//        mediaPlayer.prepare()
        try {
            mediaPlayer!!.setDataSource(audiourl)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
//            mediaPlayer.start()
//            showStopImage()
//            isplay = true
        } catch (e: IOException) {
            e.printStackTrace()
        }
        Toast.makeText(this, "Audio started playing", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer!!.release()
    }

}