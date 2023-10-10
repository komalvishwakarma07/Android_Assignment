package com.example.module4application.que_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.module4application.R

class HideActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var btnHide: Button
    private lateinit var btnShow: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide)

        textView = findViewById(R.id.textView)
        btnHide = findViewById(R.id.btnHide)
        btnShow = findViewById(R.id.btnShow)

        btnHide.setOnClickListener {
            hideTextView()
        }

        btnShow.setOnClickListener {
            showTextView()
        }
    }
    private fun hideTextView() {
        textView.visibility = View.INVISIBLE
    }

    private fun showTextView() {
        textView.visibility = View.VISIBLE
    }
}