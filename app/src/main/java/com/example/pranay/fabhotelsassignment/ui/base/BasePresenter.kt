package com.example.pranay.fabhotelsassignment.ui.base

import com.example.pranay.fabhotelsassignment.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by @pranay on 27/12/17.
 */
open class BasePresenter<V : MvpView> @Inject constructor(private val dataManager: DataManager, private val mCompositeDisposable: CompositeDisposable): MvpPresenter<V> {

    private var mMvpView: V? = null

    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    override fun onDetach() {
        mCompositeDisposable.dispose()
        mMvpView = null
    }

    fun isViewAttached(): Boolean {
        return mMvpView != null
    }

    fun getMvpView(): V {
        return mMvpView!!
    }

    fun getCompositeDisposible(): CompositeDisposable{
        return mCompositeDisposable
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    fun getDataManager(): DataManager {
        return dataManager
    }

    override fun handleApiError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")
}