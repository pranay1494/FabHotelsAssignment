package com.example.pranay.fabhotelsassignment.ui.base

import android.support.annotation.StringRes

/**
 * Created by @pranay on 27/12/17.
 */
interface MvpView {
    fun showLoading(message: String)

    fun hideLoading()

    fun showToast(@StringRes resId: Int)

    fun showToast(message: String?)

    fun isNetworkConnected(): Boolean

    fun hideKeyboard()

    fun invalidAuthCode()
}