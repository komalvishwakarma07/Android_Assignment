package com.example.module7application.ques7

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.module7application.R
import com.example.module7application.databinding.ActivityWifiBinding

class WifiActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWifiBinding
    private lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWifiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wifiManager=applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

//        binding.wifiSwitch.isChecked=wifiManager.isWifiEnabled
        binding.wifiSwitch.isChecked = false
        binding.wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
            wifiManager.isWifiEnabled = isChecked
            if (isChecked){
                Toast.makeText(this, "Wifi on", Toast.LENGTH_SHORT).show()
            }
        }

    }
}