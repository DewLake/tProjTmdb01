package com.example.date121401_tmdb.popularlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.date121401_tmdb.R
import com.example.date121401_tmdb.nowplayinglist.NowPlayingListItemModel
import com.example.date121401_tmdb.webapi.TmdbRepository

class PopularListAdapter(
        private var dataList: List<PopularListItemModel>,
        private val fnDelegate: ()->Unit
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /** 更新資料, !!注意: 暫寫, 應改為訂閱可觀察, 避免手動設置出錯 */
    fun updateDataBy(newDataList: List<PopularListItemModel>) {
        this.dataList = newDataList
        this.notifyDataSetChanged()     // 要(手動)呼叫嗎?
    } // end updateDataBy().


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.popular_list_item, parent, false)
        val holder = ItemViewHolder(itemView, fnDelegate)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val h = holder as ItemViewHolder
        val data = dataList[position]
        h.onBind(data, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    /////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////// interface, IClickItemPerformer
    interface IItemClickedPerformer {
        fun perform(): Unit
    }
    ///////////////////////////////////////////////////////////////// interface, IClickItemPerformer end
    ///////////////////////////////////////////////////////////////// ViewHolder.
    class ItemViewHolder(
        itemView: View,
        fnDelegate: ()->Unit
    ) : RecyclerView.ViewHolder(itemView){
        //
        private var midxAdapter: Int = -1        // index of adapter position
        private val imvImage: ImageView = itemView.findViewById(R.id.imvImage__PopularListItem)
        private val txvTitle: TextView = itemView.findViewById(R.id.txvTitle__PopularListItem)
        private val txvDateMin: TextView = itemView.findViewById(R.id.txvDateMin_PopularListItem)
        private val txvRunTime: TextView = itemView.findViewById(R.id.txvRunTime_PopularListItem)
        private val txvRate: TextView = itemView.findViewById(R.id.txvPopularitye_PopularListItem)


        fun onBind(data: PopularListItemModel, position: Int) {
            midxAdapter = position

            loadImage(data)
            txvTitle.text = data.title
            txvDateMin.text = data.dateMin
            txvRunTime.text = data.runTime
            txvRate.text = data.popularity.toString()
        }

        private fun loadImage(data: PopularListItemModel) {
            val uri = TmdbRepository.GetImageUrl(data.imgSrc)
            Glide.with(itemView)
                    .load(uri)
                    .error(R.drawable.ic_launcher_background)
                    .into(imvImage)
        } // end loadImage().

        ////////// Click Event Handler
        private var clickListener = View.OnClickListener{
            Log.i("ItemViewHolder", "idx: $midxAdapter clicked.")
            fnDelegate()
        }.also { itemView.setOnClickListener(it) }
        ////////// Click Event Handler end

    } // end class ItemViewHolder.
    ///////////////////////////////////////////////////////////////// ViewHolder end.
} // end class PopularListAdapter.
