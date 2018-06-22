package com.example.pranay.fabhotelsassignment.ui.hotelsListing

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.pranay.fabhotelsassignment.R
import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity
import com.example.pranay.fabhotelsassignment.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by pranay on 21/06/18.
 */
class HotelListActivity : BaseActivity(),HotelsMvpView {

    @Inject
    lateinit var mPresenter: HotelsPresenter

    lateinit var adapter:RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActivityComponent().inject(this)

        mPresenter.onAttach(this)
        setRecyclerView()
        mPresenter.getHotelListings()
    }

    override fun updateRecylerView(hotelsList: List<ListPropertyEntity>) {
        rvHotelList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = RecyclerViewAdapter(this,hotelsList)
        rvHotelList.adapter = adapter
    }

    override fun setRecyclerView() {
        rvHotelList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = RecyclerViewAdapter(this, listOf())
        rvHotelList.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mPresenter!=null){
            mPresenter.onDetach()
        }
    }
}