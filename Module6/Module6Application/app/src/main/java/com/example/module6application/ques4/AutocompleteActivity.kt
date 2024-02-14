package com.example.module6application.ques4

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.module6application.R
import com.example.module6application.databinding.ActivityAutocompleteBinding
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class AutocompleteActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityAutocompleteBinding

//    private lateinit var placesClient: PlacesClient
//    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var apiKey: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAutocompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetching API_KEY which we wrapped
        try {
            val ai: ApplicationInfo = applicationContext.packageManager
                .getApplicationInfo(applicationContext.packageName, PackageManager.GET_META_DATA)
            val value = ai.metaData?.getString("Api_Key")
            apiKey = value ?: ""
        } catch (e: PackageManager.NameNotFoundException) {
            // Handle the error if the API key is not found
            Toast.makeText(applicationContext, "API Key not found", Toast.LENGTH_SHORT).show()
            return
        }

        // Check if API key is empty
        if (apiKey.isEmpty()) {
            Toast.makeText(applicationContext, "API Key is empty", Toast.LENGTH_SHORT).show()
            return
        }

        // Initialize the Places SDK only if API key is not empty
        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, apiKey)
        }

        // Initialize Autocomplete Fragment
        val autocompleteFragment =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment1) as AutocompleteSupportFragment?

        // Information that we wish to fetch after typing the location and clicking on one of the options
        autocompleteFragment?.setPlaceFields(
            listOf(
                Place.Field.NAME,
                Place.Field.ADDRESS,
                Place.Field.PHONE_NUMBER,
                Place.Field.LAT_LNG,
                Place.Field.OPENING_HOURS,
                Place.Field.RATING,
                Place.Field.USER_RATINGS_TOTAL
            )
        )

        // Display the fetched information after clicking on one of the options
        autocompleteFragment?.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                // Text view where we will append the information that we fetch
                val textView = findViewById<TextView>(R.id.tv1)

                // Information about the place
                val name = place.name
                val address = place.address
                val phone = place.phoneNumber ?: ""
                val latLng = place.latLng
                val latitude = latLng?.latitude ?: 0.0
                val longitude = latLng?.longitude ?: 0.0

                val isOpenStatus = if (place.isOpen) {
                    "Open"
                } else {
                    "Closed"
                }

                val rating = place.rating ?: 0.0
                val userRatings = place.userRatingsTotal ?: 0

                textView.text =
                    "Name: $name \nAddress: $address \nPhone Number: $phone \n" +
                            "Latitude, Longitude: $latitude , $longitude \nIs open: $isOpenStatus \n" +
                            "Rating: $rating \nUser ratings: $userRatings"
            }

            override fun onError(status: Status) {
                // Handle errors
                Toast.makeText(applicationContext, "Error: ${status.statusMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}