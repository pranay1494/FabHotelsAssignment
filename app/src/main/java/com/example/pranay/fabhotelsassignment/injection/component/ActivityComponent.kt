package com.example.pranay.fabhotelsassignment.injection.component;


import com.example.pranay.fabhotelsassignment.injection.PerActivity
import com.example.pranay.fabhotelsassignment.injection.module.ActivityModule
import com.example.pranay.fabhotelsassignment.ui.home.HomeActivity
import com.example.pranay.fabhotelsassignment.ui.hotelsListing.HotelListActivity
import dagger.Component;

/**
 * Created by Shashank on 28/09/17.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(hotelListActivity: HotelListActivity)
}
