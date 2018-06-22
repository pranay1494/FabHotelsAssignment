package com.example.pranay.fabhotelsassignment.ui.base


/**
 * Created by @pranay on 27/12/17.
 */
interface MvpPresenter<V : MvpView> {
    fun onAttach(mvpView: V)

    fun onDetach()

    fun handleApiError()
}