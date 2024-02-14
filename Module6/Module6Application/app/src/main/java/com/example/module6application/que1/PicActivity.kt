package com.example.module6application.que1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.module6application.R
import com.example.module6application.databinding.ActivityPicBinding
import java.io.File

class PicActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPicBinding
    private var imageUri: Uri? = null

    private var cameracontract=registerForActivityResult(ActivityResultContracts.TakePicture()){
        if (it){
            binding.ivThumbnail.setImageURI(imageUri)
        }
    }

    private var gallarycontract=registerForActivityResult(ActivityResultContracts.GetContent()){  uri: Uri? ->
        if (uri != null) {
            imageUri = uri
            binding.ivThumbnail.setImageURI(imageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityPicBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.captureFromCameraButton.setOnClickListener {
            imageUri = createImageUri()
            cameracontract.launch(imageUri)
        }
        binding.chooseFromGalleryButton.setOnClickListener {
            gallarycontract.launch("image/*")
        }
    }

    private fun createImageUri(): Uri? {
        var fileName = "${System.currentTimeMillis()}.jpg"

        var imageFile = File(filesDir, fileName)

        return FileProvider.getUriForFile(
            this,
            "com.example.module6application.file_provider",
            imageFile
        )
    }
}