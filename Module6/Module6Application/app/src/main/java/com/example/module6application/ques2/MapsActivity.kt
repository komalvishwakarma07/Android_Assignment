package com.example.module6application.ques2

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.module6application.R
import com.example.module6application.databinding.ActivityMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        checkLocationPermission()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        setUpLocationUpdate()
    }


    private fun setUpLocationUpdate() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            locationRequest = LocationRequest.Builder(5000L)
                .setIntervalMillis(5000)
                .setPriority(android.location.LocationRequest.QUALITY_HIGH_ACCURACY)
                .build()
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {

                if (locationResult != null) {
                    for (location in locationResult.locations) {
                        updateMap(location)
                    }
                }

            }
        }

    }

    private fun updateMap(location: Location?) {
        mMap.clear()

        mMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    location!!.latitude,
                    location.longitude
                )
            ).title(getAddressFromLocation(this, location))
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(location.latitude, location.longitude), 16.0f))

        Toast.makeText(this, "Location updated after 5 seconds", Toast.LENGTH_SHORT).show()
    }
    private fun getAddressFromLocation(context: Context, location: Location?) : String{
        val geocoder = Geocoder(context, Locale.getDefault())
        var addressText = ""

        val addresses: List<Address> =
            geocoder.getFromLocation(location!!.latitude, location.longitude, 1)!!

        if (addresses.isNotEmpty()) {
            val address = addresses[0]
            for (i in 0..address.maxAddressLineIndex) {
                addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
            }
        }

        return addressText
    }
    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
        }



    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val latLng = LatLng(21.181484372669416, 72.82464929357309)
        mMap.addMarker(MarkerOptions().position(latLng).title("Nirmal Hospital"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            100 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // ask for network availability
                    if (isNetworkAvailable()) {

                        // look for current location
                        startLocationUpdate()

                    } else {
                        Toast.makeText(this, "Internet connection issue found", Toast.LENGTH_SHORT)
                            .show()
                    }

                } else {
                    Toast.makeText(this, "permission not granted", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun startLocationUpdate() {
        if (locationEnabled()) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android. Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }

            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)

            /*fusedLocationClient.lastLocation.addOnSuccessListener { location ->

                if (location != null) {

                    mMap.addMarker(
                        MarkerOptions().position(
                            LatLng(
                                location.latitude,
                                location.longitude
                            )
                        ).title("My Location")
                    )

                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(location.latitude, location.longitude), 16.0f))


                }

            }*/
        } else {
            var intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }
    }

    private fun locationEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || capabilities.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI
                ) || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            ) {
                return true
            }
        }
        return false
    }
}

