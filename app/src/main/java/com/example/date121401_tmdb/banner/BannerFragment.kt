package com.example.date121401_tmdb.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R
import com.example.date121401_tmdb.popularlist.PopularListAdapter
import com.example.date121401_tmdb.popularlist.PopularListItemModel
import com.example.date121401_tmdb.popularlist.PuplarListDataSource1

/**
 * Banner
 */
class BannerFragment : Fragment() {
    // TAG
    val TAG = "[TAG]-${BannerFragment::class.simpleName}"
    //
    private lateinit var rcvBanner: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_banner, container, false)

        // init recyclerview
        this.initRecyclerView(view)

        return view
    } // end onCreateView().

    /**
     * Banner Recycler view initialize.
     */
    private fun initRecyclerView(view: View) {
        this.rcvBanner = view.findViewById<RecyclerView>(R.id.rcvBanner).apply {
            adapter = BannerAdapter(BannerDataSource1)
        }
    } // end initRecyclerView()
    /////////////////////////////////////////////////////// end initialize.

} // end class BannerFragment.