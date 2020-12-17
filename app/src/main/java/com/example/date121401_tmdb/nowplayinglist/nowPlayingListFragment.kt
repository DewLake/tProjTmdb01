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
    private lateinit var rcvBanner: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_now_playing_list, container, false)

        // init recyclerview
        this.initRecyclerView(view)

        return view
    } // end onCreateView().

    /**
     * Banner Recycler view initialize.
     */
    private fun initRecyclerView(view: View) {
        this.rcvBanner = view.findViewById<RecyclerView>(R.id.rcvBanner).apply {
            adapter = nowPlayingListAdapter(BannerDataSource1)
        }
    } // end initRecyclerView()
    /////////////////////////////////////////////////////// end initialize.
    /////////////////////////////////////////////////////// api function:
    /**
     * Get Now Playing
     */
    fun GetNowPlaying(page:Int = 1) {
        val onDataReadyCallback: (GetNowPlayingResponse) -> Unit = { response ->
            println(response)
        }

        TmdbRepository.GetNowPlaying(page, onDataReadyCallback)
    } // end GetNowPlaying().
    /////////////////////////////////////////////////////// api function end.

} // end class BannerFragment.