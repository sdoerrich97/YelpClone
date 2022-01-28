package com.example.yelpclone

/*
 * Collection of classes to parse out the json-file which we get by calling the Yelp API.
 */

import com.google.gson.annotations.SerializedName

data class YelpSearchResults(
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurants: List<YelpRestaurant>
)

data class YelpRestaurant(
    // If the declared variable name matches the name in the json, no need to use @SerializedName
    val name: String,
    val rating: Double,
    val price: String,
    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val imageUrl: String,

    val categories: List<YelpCategory>,
    val location: YelpLocation
) {
    // Method of YelpRestaurant data class
    fun displayDistance(): String {
        val milesPerMeter = 0.000621371
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles mi"
    }
}

// data class for the categories attribute of the specific restaurants
data class YelpCategory(
    val title: String
)

// data class for the address of the specific restaurants
data class YelpLocation(
    @SerializedName("address1") val address: String
)