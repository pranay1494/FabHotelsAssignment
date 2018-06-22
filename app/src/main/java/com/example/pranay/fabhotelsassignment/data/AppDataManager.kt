package com.example.pranay.fabhotelsassignment.data

import com.example.pranay.fabhotelsassignment.data.db.DbHelper
import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity
import com.example.pranay.fabhotelsassignment.data.local.PreferenceManager
import com.example.pranay.fabhotelsassignment.data.remote.ApiManager
import com.example.pranay.fabhotelsassignment.data.remote.model.FabModel
import com.example.pranay.fabhotelsassignment.data.remote.model.PropertyListing
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by @pranay on 26/12/17.
 */
class AppDataManager @Inject constructor(preferenceManager: PreferenceManager, apiManager: ApiManager, mDbHelper: DbHelper) : DataManager,DbHelper {

    private val mPreferenceManager : PreferenceManager = preferenceManager
    private val mApiManager : ApiManager = apiManager
    private val mDbHelper : DbHelper = mDbHelper

    override fun setWelcomeMessage(msg: String) {
        mPreferenceManager.setWelcomeMessage(msg)
    }

    override fun getWelcomeMessage(): String? {
        return mPreferenceManager.getWelcomeMessage()
    }
    override fun getHotelListings(): Observable<FabModel> {
        return mApiManager.getHotelListings()
    }
    override fun getAllProperties(): Observable<List<ListPropertyEntity>> {
        return mDbHelper.getAllProperties()
    }
    override fun saveProperties(listPropertyEntity: List<ListPropertyEntity>): Observable<Boolean> {
        return mDbHelper.saveProperties(listPropertyEntity)
    }

}