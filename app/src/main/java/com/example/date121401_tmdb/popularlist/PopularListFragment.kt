package com.example.date121401_tmdb.popularlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R
import com.example.date121401_tmdb.webapi.ITmdbApiService
import com.example.date121401_tmdb.webapi.TmdbRetrofitManager
import com.example.date121401_tmdb.webapi.model.MovieDetailResponse
import com.example.date121401_tmdb.webapi.model.getnowplaying.GetNowPlayingResponse
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
    private val fnDelegate: ()->Unit = { GetNowPlaying(1) }

    /**
     * 送出請求, 查詢 API
     */
    private fun fetchMovieDetail():Unit {
        val apiService = TmdbRetrofitManager.service
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

    /**
     * Get Now Playing
     */
    private fun GetNowPlaying(page:Int = 1) {
        val apiService = TmdbRetrofitManager.service
        apiService.getNowPlaying(page).enqueue(object: Callback<GetNowPlayingResponse>{
            override fun onResponse(
                call: Call<GetNowPlayingResponse>,
                response: Response<GetNowPlayingResponse>
            ) {
                Log.d("$TAG-GetNowPlaying","onResponse")
//                println("......" + response.body())

            }

            override fun onFailure(call: Call<GetNowPlayingResponse>, t: Throwable) {
                Log.d("$TAG-GetNowPlaying","onFailure")
            }

        })
    } // end GetNowPlaying().
    /////////////////////////////////////////////////////// api function end.
    ///////////////////////////////////////////////////////
} // end PopularListFragment.