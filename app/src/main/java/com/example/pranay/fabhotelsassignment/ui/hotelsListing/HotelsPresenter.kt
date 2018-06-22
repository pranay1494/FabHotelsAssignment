package com.example.pranay.fabhotelsassignment.ui.hotelsListing

import android.util.Log
import com.example.pranay.fabhotelsassignment.data.DataManager
import com.example.pranay.fabhotelsassignment.data.remote.model.FabModel
import com.example.pranay.fabhotelsassignment.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by pranay on 21/06/18.
 */
class HotelsPresenter @Inject constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<HotelsMvpView>(dataManager, compositeDisposable) {

    fun getHotelListings(){
        if (getMvpView().isNetworkConnected()){
            getMvpView().showLoading("Please wait...")
            getCompositeDisposible().add(
                    getDataManager().getHotelListings()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                updateDb(it)
                            },{
                                getMvpView().hideLoading()
                                getMvpView().showToast("something went wrong..")
                                updateRecyclerView()
                            }))
        }else{
            //showing data using db if network is not available.
            updateRecyclerView()
        }
    }

    private fun updateDb(model: FabModel) {
        getDataManager().saveProperties(model.propertyListing).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    updateRecyclerView()
                    getMvpView().hideLoading()
                },{
                    getMvpView().hideLoading()
                })
    }

    private fun updateRecyclerView() {
        getDataManager().getAllProperties().observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("db_data",it.get(0).name)
                    getMvpView().updateRecylerView(it)
                },{
                    getMvpView().showToast("error fetching data from db..")
                    getMvpView().showNoDataErrorMsg()
                })
    }
}