package com.example.pranay.fabhotelsassignment.injection.component

import com.example.pranay.fabhotelsassignment.injection.PerActivity
import com.example.pranay.fabhotelsassignment.injection.module.FragmentModule
import dagger.Component

/**
 * Created by @pranay on 27/12/17.
 */
@PerActivity
@Component (dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
}