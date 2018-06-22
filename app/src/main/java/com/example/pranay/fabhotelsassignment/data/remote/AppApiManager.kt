package com.example.pranay.fabhotelsassignment.data.remote

import android.content.Context
import com.example.pranay.fabhotelsassignment.data.remote.model.FabModel
import com.example.pranay.fabhotelsassignment.injection.ApplicationContext
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by @pranay on 26/12/17.
 */
class AppApiManager @Inject constructor(@ApplicationContext var context: Context) : ApiManager {
    override fun getHotelListings(): Observable<FabModel> {
        return ApiClient.getInstance().getHotelListings();
    }
}