package com.example.pranay.fabhotelsassignment.injection.component;

import com.example.pranay.fabhotelsassignment.FabApplication

import com.example.pranay.fabhotelsassignment.data.DataManager;
import com.example.pranay.fabhotelsassignment.data.db.AppDbHelper
import com.example.pranay.fabhotelsassignment.data.db.DbHelper
import com.example.pranay.fabhotelsassignment.injection.module.ApplicationModule

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by @pranay on 27/12/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(fabApplication : FabApplication)

    fun getDataManager(): DataManager


}
