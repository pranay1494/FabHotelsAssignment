package com.example.pranay.fabhotelsassignment.ui.home

import android.util.Log
import com.example.pranay.fabhotelsassignment.data.DataManager
import com.example.pranay.fabhotelsassignment.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by @pranay on 27/12/17.
 */
class HomePresenter @Inject constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<HomeMvpView>(dataManager, compositeDisposable) {
    fun getWelcomeMessage() {
        getDataManager().setWelcomeMessage("Welcome")
        Log.d("injectiontest", getDataManager().getWelcomeMessage())
        getMvpView().showToast(getDataManager().getWelcomeMessage())
    }
}