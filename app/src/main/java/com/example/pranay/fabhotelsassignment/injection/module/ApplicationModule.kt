package com.example.pranay.fabhotelsassignment.injection.module;

import android.app.Application;
import android.content.Context;

import com.example.pranay.fabhotelsassignment.data.AppDataManager;
import com.example.pranay.fabhotelsassignment.data.DataManager;
import com.example.pranay.fabhotelsassignment.data.db.AppDbHelper
import com.example.pranay.fabhotelsassignment.data.db.DbHelper
import com.example.pranay.fabhotelsassignment.data.db.DbOpenHelper
import com.example.pranay.fabhotelsassignment.data.local.AppPreferenceManager;
import com.example.pranay.fabhotelsassignment.data.local.PreferenceManager;
import com.example.pranay.fabhotelsassignment.data.remote.ApiManager;
import com.example.pranay.fabhotelsassignment.data.remote.AppApiManager;
import com.example.pranay.fabhotelsassignment.injection.ApplicationContext;
import com.example.pranay.fabhotelsassignment.injection.DatabaseInfo
import com.example.pranay.fabhotelsassignment.utils.AppConstants

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by @pranay on 27/12/17.
 */
@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context {
        return mApplication
    }

    @Provides
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideApiManager(appApiManager: AppApiManager): ApiManager {
        return appApiManager
    }

    @Provides
    @Singleton
    internal fun providePreferenceManager(appPreferenceManager: AppPreferenceManager): PreferenceManager {
        return appPreferenceManager
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }
}
