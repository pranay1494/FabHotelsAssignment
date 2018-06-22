package com.example.pranay.fabhotelsassignment.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by pranay on 21/06/18.
 */
class PropertyListing {
    @SerializedName("landmark")
    @Expose
    private var landmark: String? = null
    @SerializedName("city")
    @Expose
    private var city: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("reviewCount")
    @Expose
    private var reviewCount: Int? = null
    @SerializedName("price")
    @Expose
    private var price: Int? = null
    @SerializedName("ratedText")
    @Expose
    private var ratedText: String? = null

    fun getLandmark(): String? {
        return landmark
    }

    fun setLandmark(landmark: String) {
        this.landmark = landmark
    }

    fun getCity(): String? {
        return city
    }

    fun setCity(city: String) {
        this.city = city
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getReviewCount(): Int? {
        return reviewCount
    }

    fun setReviewCount(reviewCount: Int?) {
        this.reviewCount = reviewCount
    }

    fun getPrice(): Int? {
        return price
    }

    fun setPrice(price: Int?) {
        this.price = price
    }

    fun getRatedText(): String? {
        return ratedText
    }

    fun setRatedText(ratedText: String) {
        this.ratedText = ratedText
    }
}