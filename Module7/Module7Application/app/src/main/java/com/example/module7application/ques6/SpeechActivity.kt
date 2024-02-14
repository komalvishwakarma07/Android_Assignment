package com.example.module7application.ques6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import com.example.module7application.R
import com.example.module7application.databinding.ActivitySpeechBinding
import com.example.module7application.databinding.ActivitySplashBinding
import java.util.Locale

class SpeechActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpeechBinding
    private lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySpeechBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val langResult = textToSpeech.setLanguage(Locale.US)
                if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {

                }
            }
        }
        binding.speakButton.setOnClickListener {
            val textToRead =binding.editText.text.toString()
            if (textToRead.isNotEmpty()) {
                textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }

    override fun onDestroy() {
        if (textToSpeech.isSpeaking) {
            textToSpeech.stop()
        }
        textToSpeech.shutdown()
        super.onDestroy()
    }

}