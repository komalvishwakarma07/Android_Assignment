package com.example.module4application.que_17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import com.example.module4application.R
import com.example.module4application.databinding.ActivityToolbarBinding

class ToolbarActivity : AppCompatActivity() {
    lateinit var bindin:ActivityToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindin=ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(bindin.root)

    }

}