package com.example.pranay.fabhotelsassignment.ui.hotelsListing

import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity
import com.example.pranay.fabhotelsassignment.ui.base.MvpView

/**
 * Created by pranay on 21/06/18.
 */
interface HotelsMvpView : MvpView {
    fun updateRecylerView(hotelsList:List<ListPropertyEntity>)
    fun setRecyclerView()
}