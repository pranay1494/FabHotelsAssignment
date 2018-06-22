package com.example.pranay.fabhotelsassignment.ui.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.pranay.fabhotelsassignment.FabApplication
import com.example.pranay.fabhotelsassignment.injection.component.ActivityComponent
import com.example.pranay.fabhotelsassignment.injection.component.DaggerActivityComponent
import com.example.pranay.fabhotelsassignment.injection.module.ActivityModule
import com.example.pranay.fabhotelsassignment.utils.DialogUtils
import com.example.pranay.fabhotelsassignment.utils.NetworkUtils

open class BaseActivity : AppCompatActivity(), MvpView {

    private lateinit var mActivityComponent : ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as FabApplication).getApplictionComponent())
                .build()

    }

    fun getActivityComponent() : ActivityComponent {
        return mActivityComponent
    }

    override fun showLoading(message: String) {
        DialogUtils.displayProgressDialog(this, message)
    }

    override fun hideLoading() {
        DialogUtils.cancelProgressDialog()
    }

    override fun showToast(@StringRes resId: Int) {
        showToast(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun showToast(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun invalidAuthCode() {
        Toast.makeText(this, "Invalid Authcode", Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean
    {
        when(item.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
                return false
            }
        }
    }

}
