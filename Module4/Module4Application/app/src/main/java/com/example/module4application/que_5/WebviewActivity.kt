package com.example.module4application.que_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import com.example.module4application.R
import com.example.module4application.databinding.ActivityWebviewBinding

class WebviewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.settings.javaScriptEnabled=true

        binding.webView.webViewClient= WebViewClient()

        binding.webView.webChromeClient= WebChromeClient()

        loadUrl("https://www.google.com")

        binding.backButton.setOnClickListener {
            if (binding.webView.canGoBack()){
                binding.webView.goBack()
            }
        }

        binding.forwardButton.setOnClickListener {
            if (binding.webView.canGoBack()){
                binding.webView.goBack()
            }
        }

    }

    private fun loadUrl(Url: String) {
    binding.webView.loadUrl(Url)
    }
}





