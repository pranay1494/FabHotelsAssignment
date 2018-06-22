package com.example.pranay.fabhotelsassignment.ui.hotelsListing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pranay.fabhotelsassignment.R
import com.example.pranay.fabhotelsassignment.data.db.model.ListPropertyEntity

/**
 * Created by pranay on 22/06/18.
 */
class RecyclerViewAdapter(var hotelListActivity: HotelListActivity, var arrayList: List<ListPropertyEntity>) : RecyclerView.Adapter<RecyclerViewAdapter.HotelsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder {
        return HotelsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_properties_list,parent,false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        val model = arrayList[position]
        holder.name.text = model.name?:""
        holder.city.text = model.city?:""
        holder.landmark.text = model.landmark?:""
        holder.price.text = model.price?.toString()?:""
        holder.reviewCount.text = model.reviewCount?.toString()?:""
    }

    class HotelsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView!!.findViewById(R.id.tvName)
        val city:TextView = itemView!!.findViewById(R.id.tvCity)
        val landmark:TextView = itemView!!.findViewById(R.id.tvLandmark)
        val reviewCount:TextView = itemView!!.findViewById(R.id.tvReviewCount)
        val price:TextView = itemView!!.findViewById(R.id.tvPrice)
    }
}