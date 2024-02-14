package com.example.module6application.ques3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.module6application.R
import com.example.module6application.databinding.ActivityAddressBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class AddressActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding:ActivityAddressBinding
    private lateinit var map: GoogleMap
    private lateinit var addressEditText: EditText
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // Initialize addressEditText
        addressEditText = binding.addressEditText

        binding.showLocationButton.setOnClickListener {
            showLocation()
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val latLng = LatLng(21.181484372669416, 72.82464929357309)
        map.addMarker(MarkerOptions().position(latLng).title("Nirmal Hospital"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f))
    }

    private fun showLocation() {
        val address = addressEditText.text.toString().trim()
        if (address.isEmpty()) {
            Toast.makeText(this, "Please enter an address", Toast.LENGTH_SHORT).show()
            return
        }

        val location = getLocationFromAddress(address)
        if (location != null) {
            map.clear()
            val latLng = LatLng(location.latitude, location.longitude)
            map.addMarker(MarkerOptions().position(location).title(address))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
            // Show the entered address
            Toast.makeText(this, "Address: $address", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Address not found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getLocationFromAddress(address: String): LatLng? {
        val geocoder = android.location.Geocoder(this)
        try {
            val addresses = geocoder.getFromLocationName(address, 1)
            if (addresses != null && addresses.isNotEmpty()) {
                val location =  LatLng(addresses[0].latitude, addresses[0].longitude)
                return location
            }else{
                // Log an error or show a message indicating that the address was not found
                Log.e("AddressActivity", "No matching address found for: $address")
                return null
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}