package com.example.date121401_tmdb.popularlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R
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

        return view
    } // end onCreateView().

    /**
     * Popular List Recycler view initialize.
     */
    fun initPopularListRecyclerView(view: View) {
        this.rcvPopularList = view.findViewById<RecyclerView>(R.id.rcvPopularList).apply {
            adapter = PopularListAdapter(PuplarListDataSource1, fnDelegate)
        }
    }

    /////////////////////////////////////////////////////// end initialize.
    /////////////////////////////////////////////////////// api function
    //
    private val fnDelegate: ()->Unit = { GetMovieDetail() }
    //

    /////////////////////////////////////////////////////// api function:
    /**
     * Get Popular
     */
    fun GetPopular(page:Int = 1) {
        val onDataReadyCallback: (GetPopularResponse) -> Unit = {
            /* Response Schema:
                data class GetPopularResponse(
                    val page: Int,
                    val results: List<Result>,
                    val total_pages: Int,
                    val total_results: Int
                )
             */
            val result = it.results             // !! 會有非同步的問題嗎?

            val newDataList = mutableListOf<PopularListItemModel>()
            for (item in result) {
                // 用 id 再請求 Movie Detail

                newDataList.add(PopularListItemModel())
            }

            val adapter = this.rcvPopularList.adapter as PopularListAdapter
            adapter.updateDataBy(newDataList.toList())
        } // end val onDataReadyCallback.
    } // end GetPopular().



    /**
     * 送出請求, 查詢 API
     */
    private fun GetMovieDetail():Unit {
        val apiService = TmdbRetrofitManager.apiService
        apiService.fetchMovieDetail("550").enqueue(object: Callback<MovieDetailResponse>{
            override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
            ) {
                Log.d("$TAG-fetchMovieDetail","onResponse")
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.d("$TAG-fetchMovieDetail","onFailure")
            }

        }) // end enqueue

    } // end fetchMovieDetail().
    /////////////////////////////////////////////////////// api function end.
    ///////////////////////////////////////////////////////
} // end PopularListFragment.