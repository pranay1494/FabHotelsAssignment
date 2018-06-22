package com.example.pranay.fabhotelsassignment.ui.home

import android.os.Bundle
import com.example.pranay.fabhotelsassignment.R
import com.example.pranay.fabhotelsassignment.ui.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeMvpView {
//
    @Inject
    lateinit var mPresenter : HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.onAttach(this)


        mPresenter.getWelcomeMessage()
    }
}
