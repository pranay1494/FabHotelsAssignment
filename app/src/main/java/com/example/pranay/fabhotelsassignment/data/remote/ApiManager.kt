package com.example.pranay.fabhotelsassignment.data.remote

import com.example.pranay.fabhotelsassignment.data.remote.model.FabModel
import io.reactivex.Observable

/**
 * Created by @pranay on 26/12/17.
 */
interface ApiManager {
    fun getHotelListings(): Observable<FabModel>
}