package com.example.module5.ques4

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.example.module5.R
import com.example.module5.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileImageView: ImageView

    private val PICK_IMAGE_REQUEST = 1

    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profileImageView = findViewById(R.id.profileImageView)
        val btnChooseImage: Button = findViewById(R.id.btnChooseImage)
        val btnUploadImage: Button = findViewById(R.id.btnUploadImage)

        btnChooseImage.setOnClickListener {
            openGallery()
        }

        btnUploadImage.setOnClickListener {
            uploadImage()
        }

    }

    private fun uploadImage() {

    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            val inputStream = contentResolver.openInputStream(selectedImageUri!!)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            profileImageView.setImageBitmap(bitmap)
        }
    }
}