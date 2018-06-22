package com.example.pranay.fabhotelsassignment.data.remote

import com.example.pranay.fabhotelsassignment.data.remote.model.FabModel
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by @pranay on 26/12/17.
 */
class ApiClient (){

    private lateinit var mRetrofit: Retrofit
    private var mApiServiceEndPoints : ApiEndpoints? = null

    init {
        setUpClient()
    }

    private fun setUpClient() {
        val builder = OkHttpClient.Builder()
        val httpLogger = HttpLoggingInterceptor()
        httpLogger.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(httpLogger)

        mRetrofit = Retrofit.Builder()
                    .baseUrl("https://api.myjson.com/bins/bs67u/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
                    .build()

        mApiServiceEndPoints = getApiService()
    }

    private fun getApiService(): ApiEndpoints {
        if (mApiServiceEndPoints == null){
            mApiServiceEndPoints = mRetrofit.create(ApiEndpoints::class.java)
        }
        return mApiServiceEndPoints!!
    }


    private interface ApiEndpoints {
        @GET("https://api.myjson.com/bins/bs67u")
        fun getPropertyList(): Observable<FabModel>
    }

    companion object {
        private var mInstance : ApiClient? = null

        fun getInstance() : ApiClient {
            if(mInstance == null){
                mInstance = ApiClient()
            }
            return mInstance!!
        }
    }

    fun getHotelListings(): Observable<FabModel> {
        return getApiService().getPropertyList()
    }

}