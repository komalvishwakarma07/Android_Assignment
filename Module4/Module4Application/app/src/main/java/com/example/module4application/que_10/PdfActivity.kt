package com.example.module4application.que_10

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.module4application.R
import com.example.module4application.databinding.ActivityPdfBinding

class PdfActivity : AppCompatActivity() {
    lateinit var binding:ActivityPdfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnopen.setOnClickListener {
            openPdfFile()
        }
    }

    private fun openPdfFile() {
        val pdfFileUri = Uri.parse("https://www.africau.edu/images/default/sample.pdf")// Change the file name as needed

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(pdfFileUri, "application/pdf")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)


            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Log.e("PdfActivity","error opning pdf : ${e.message}") }
                Toast.makeText(this, "No PDF viewer installed", Toast.LENGTH_SHORT).show()
            }

    }
