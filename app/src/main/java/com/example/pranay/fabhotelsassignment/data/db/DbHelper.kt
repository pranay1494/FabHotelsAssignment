package com.example.pranay.fabhotelsassignment.data.db

import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity
import com.example.pranay.fabhotelsassignment.data.remote.model.PropertyListing
import io.reactivex.Observable

/**
 * Created by pranay on 22/06/18.
 */
interface DbHelper {

    fun getAllProperties(): Observable<List<ListPropertyEntity>>

    fun saveProperties(listPropertyEntity: List<ListPropertyEntity>) : Observable<Boolean>
}