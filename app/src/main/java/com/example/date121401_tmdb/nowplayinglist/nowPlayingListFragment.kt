package com.example.date121401_tmdb.nowplayinglist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R
import com.example.date121401_tmdb.webapi.TmdbRepository
import com.example.date121401_tmdb.webapi.model.nowplaying.GetNowPlayingResponse

/**
 * Banner
 */
class nowPlayingListFragment : Fragment() {
    // TAG
    val TAG = "[TAG]-${nowPlayingListFragment::class.simpleName}"
    //
    private lateinit var rcvNowPlaying: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_now_playing_list, container, false)

        // init recyclerview
        this.initRecyclerView(view)

        // update data
        this.GetNowPlaying(1)

        return view
    } // end onCreateView().

    /**
     * Banner Recycler view initialize.
     */
    private fun initRecyclerView(view: View) {
        this.rcvNowPlaying = view.findViewById<RecyclerView>(R.id.rcvBanner).apply {
            adapter = nowPlayingListAdapter(NowPlayingListDataSource1)
        }
    } // end initRecyclerView()
    /////////////////////////////////////////////////////// end initialize.
    /////////////////////////////////////////////////////// api function:
    /**
     * Get Now Playing
     */
    fun GetNowPlaying(page:Int = 1) {
        val onDataReadyCallback: (GetNowPlayingResponse) -> Unit = { response ->
            /* Response Schema:
            {
                dates: Dates,
                page: Int,
                results: List<Result>,
                total_pages: Int,
                total_results: Int
            }
             */
            val result = response.results       // !! 會有非同步的問題嗎?

            val newDataList = mutableListOf<NowPlayingListModel>()
            for (item in result) {
                newDataList.add(NowPlayingListModel(item.id, item.backdrop_path))
            }

            val adapter = this.rcvNowPlaying.adapter as nowPlayingListAdapter
            adapter.updateDataBy(newDataList.toList())
        } // end val onDataReadyCallback.

        TmdbRepository.GetNowPlaying(page, onDataReadyCallback)
    } // end GetNowPlaying().
    /////////////////////////////////////////////////////// api function end.

} // end class BannerFragment.