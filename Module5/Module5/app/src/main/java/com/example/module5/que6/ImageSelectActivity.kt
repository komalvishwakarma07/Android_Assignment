package com.example.module5.que6

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.module5.R
import com.example.module5.databinding.ActivityImageSelectBinding

class ImageSelectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageSelectBinding
    private val PICK_IMAGE_REQUEST = 1
    private val REQUEST_IMAGE_CAPTURE = 2
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImageSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = findViewById(R.id.profileImageView)

        val chooseFromGalleryButton: Button = findViewById(R.id.chooseFromGalleryButton)
        chooseFromGalleryButton.setOnClickListener {
            openGallery()
        }

        binding.captureFromCameraButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this, android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraLauncher.launch(cameraIntent)
            } else {
                cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
            }
        }


    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PICK_IMAGE_REQUEST -> {
                    data?.data?.let { uri ->
                        displaySelectedImage(uri)
                    }
                }

                REQUEST_IMAGE_CAPTURE -> {
                    val imageBitmap = data?.extras?.get("data") as? Bitmap
                    imageBitmap?.let {
                        displayCapturedImage(it)
                    }
                }
            }
        }
    }

    private fun displaySelectedImage(imageUri: android.net.Uri) {
        imageView.setImageURI(imageUri)
    }

    private fun displayCapturedImage(imageBitmap: Bitmap) {
        imageView.setImageBitmap(imageBitmap)
    }

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as? Bitmap
                if (imageBitmap != null) {
                    binding.profileImageView.setImageBitmap(imageBitmap)
                } else {
                    Toast.makeText(this, "Failed to capture image", Toast.LENGTH_SHORT).show()
                }
            }
        }

    private val cameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraLauncher.launch(cameraIntent)
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }

}