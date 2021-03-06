package com.example.date121401_tmdb.popularlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R
import com.example.date121401_tmdb.webapi.TmdbRepository
import com.example.date121401_tmdb.webapi.TmdbRetrofitManager
import com.example.date121401_tmdb.webapi.model.moviedetail.MovieDetailResponse
import com.example.date121401_tmdb.webapi.model.popular.GetPopularResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Popular List Fragment.
 */
class PopularListFragment : Fragment() {
    // TAG
    val TAG = "[TAG]-${PopularListItemModel::class.simpleName}"
    //
    private lateinit var rcvPopularList: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_popular_list, container, false)

        // init recyclerview
        this.initPopularListRecyclerView(view)

        // update data
        this.GetPopular(1)

        return view
    } // end onCreateView().

    /**
     * Popular List Recycler view initialize.
     */
    fun initPopularListRecyclerView(view: View) {
        this.rcvPopularList = view.findViewById<RecyclerView>(R.id.rcvPopularList).apply {
            adapter = PopularListAdapter(PuplarListDataSource1, fnDelegate)
//            val populist = GetPopular(1)
//            adapter = PopularListAdapter(populist, fnDelegate)
        }
    }

    /////////////////////////////////////////////////////// end initialize.
    /////////////////////////////////////////////////////// api function
    //
    private val fnDelegate: ()->Unit = { fnDelegateCalled() }
    //

    /////////////////////////////////////////////////////// api function:
    /**
     * Get Popular
     * 查詢 Popular 並顯示清單.
     */
    fun GetPopular(page:Int = 1) {
        // callback: 查詢結果顯示出來
        val onDataReadyCallback: (GetPopularResponse) -> Unit = {
            val newDataList = PopularListModel.from(it)

            // TODO(這是錯誤的寫法, 應考慮非同步的問題: newDataList 可能查詢結果還沒準備好)
            val adapter = this.rcvPopularList.adapter as PopularListAdapter
            adapter.updateDataBy(newDataList.toList())
        } // end val onDataReadyCallback.

        // 送出請求
        TmdbRepository.GetPopular(page, onDataReadyCallback)
    } // end GetPopular().


    /**
     *
     */
    fun fnDelegateCalled() {
        print("fnDelegateCalled")
    }
    /////////////////////////////////////////////////////// api function end.
    ///////////////////////////////////////////////////////
} // end PopularListFragment.