package com.example.pranay.fabhotelsassignment.data.remote.model

import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by pranay on 21/06/18.
 */
class FabModel {
    @SerializedName("propertyListing")
    @Expose
    var propertyListing: ArrayList<ListPropertyEntity> = arrayListOf()
}