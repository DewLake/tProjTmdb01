package com.example.date121401_tmdb.nowplayinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R

class nowPlayingListAdapter(private val dataList: List<BannerModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_item, parent, false)
        val holder = ItemViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        val h = holder as ItemViewHolder
        h.onBind(data, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    ///////////////////////////////////////////////////////////////// ViewHolder.
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var mPosition: Int = -1       // position from adapter onBindViewHolder().
        // Views
        private var txvSrc = itemView.findViewById<TextView>(R.id.txvSrc_BannerItem)

        fun onBind(data: BannerModel, position: Int) {
            mPosition = position
            txvSrc.text = data.imgSrc
        }
    } // end class ItemViewHolder.
    ///////////////////////////////////////////////////////////////// ViewHolder end.
} // end class BannerAdapter.