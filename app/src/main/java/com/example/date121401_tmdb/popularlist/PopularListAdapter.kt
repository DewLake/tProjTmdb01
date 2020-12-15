package com.example.date121401_tmdb.popularlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R
import java.util.zip.Inflater

class PopularListAdapter(private val dataList: List<PopularListItemModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.popular_list_item, parent, false)
        val holder = ItemViewHolder(itemView)
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
    ///////////////////////////////////////////////////////////////// ViewHolder.
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //
        private var midxAdapter: Int = -1        // index of adapter position
        private var txvId: TextView = itemView.findViewById(R.id.txvId_PopularListItem)
        private var txvTitle: TextView = itemView.findViewById(R.id.txvTitle_PopularListItem)


        fun onBind(data: PopularListItemModel, position: Int) {
            midxAdapter = position
            txvId.text = data.id.toString()
            txvTitle.text = data.title
        }

        ////////// Click Event Handler
        private var clickListener = View.OnClickListener{
            Log.i("ItemViewHolder", "idx: $midxAdapter clicked.")
        }.also { itemView.setOnClickListener(it) }
        ////////// Click Event Handler end

    } // end class ItemViewHolder.
    ///////////////////////////////////////////////////////////////// ViewHolder end.
} // end class PopularListAdapter.
