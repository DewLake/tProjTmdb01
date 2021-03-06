package com.example.date121401_tmdb.nowplayinglist

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.date121401_tmdb.R
import com.example.date121401_tmdb.webapi.TmdbRepository

class nowPlayingListAdapter(private var dataList: List<NowPlayingListItemModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /** 更新資料, !!注意: 暫寫, 應改為訂閱可觀察, 避免手動設置出錯 */
    fun updateDataBy(newDataList: List<NowPlayingListItemModel>) {
        this.dataList = newDataList
        this.notifyDataSetChanged()     // 要(手動)呼叫嗎?
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.now_playing_list_item, parent, false)
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
        private var txvSrc = itemView.findViewById<TextView>(R.id.txvSrc_NowPlayingListItem)
        private var imvImage = itemView.findViewById<ImageView>(R.id.imvImage_NowPlayingListItem)

        fun onBind(data: NowPlayingListItemModel, position: Int) {
            mPosition = position
             txvSrc.text = data.id.toString()

            // Image:
            // val uri = ContextCompat.getDrawable(itemView.context, R.drawable.ic_launcher_background)
            // Glide.with(itemView).load(uri).into(imvImage)
            loadImage(data)
        } // end onBind().

        private fun loadImage(data: NowPlayingListItemModel) {
            val uri = TmdbRepository.GetImageUrl(data.imgSrc)
            Glide.with(itemView)
                    .load(uri)
                    .error(R.drawable.ic_launcher_background)
                    .into(imvImage)
        } // end loadImage().
    } // end class ItemViewHolder.
    ///////////////////////////////////////////////////////////////// ViewHolder end.
} // end class BannerAdapter.