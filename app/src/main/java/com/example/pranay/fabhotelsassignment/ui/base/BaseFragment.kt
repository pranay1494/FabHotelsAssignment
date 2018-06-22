package com.example.pranay.fabhotelsassignment.ui.base

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import com.example.pranay.fabhotelsassignment.FabApplication
import com.example.pranay.fabhotelsassignment.injection.component.DaggerFragmentComponent
import com.example.pranay.fabhotelsassignment.injection.component.FragmentComponent
import com.example.pranay.fabhotelsassignment.injection.module.FragmentModule
import com.example.pranay.fabhotelsassignment.utils.KeyboardUtils

/**
 * Created by @pranay on 27/12/17.
 */
abstract class BaseFragment : Fragment(), MvpView {

    var baseActivity: BaseActivity? = null
        private set
    private var mFragmentComponent: FragmentComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    fun getmFragmentComponent(): FragmentComponent? {
        if (mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(FragmentModule(Fragment()))
                    .applicationComponent(FabApplication.get(activity).getApplictionComponent())
                    .build()
        }
        return mFragmentComponent
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (activity is BaseActivity) {
            this.baseActivity = activity
            //            activity.onFragmentAttached();
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.baseActivity = context
            //            activity.onFragmentAttached();
        }
    }

    override fun showLoading(message: String) {
        if (baseActivity != null) {
            baseActivity!!.showLoading(message)
        }
    }

    override fun hideLoading() {
        if (baseActivity != null) {
            baseActivity!!.hideLoading()
        }
    }

    override fun showToast(message: String?) {
        if (baseActivity != null) {
            baseActivity!!.showToast(message)
        }
    }

    override fun showToast(@StringRes resId: Int) {
        if (baseActivity != null) {
            baseActivity!!.showToast(resId)
        }
    }

    override fun onDetach() {
        baseActivity = null
        KeyboardUtils.hideSoftInput(activity)
        super.onDetach()
    }

    override fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached(context: Context)

        fun onFragmentDetached(tag: String)
    }

    override fun invalidAuthCode() {
    }
}
