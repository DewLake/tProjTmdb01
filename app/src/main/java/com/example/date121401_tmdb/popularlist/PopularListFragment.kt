package com.example.date121401_tmdb.popularlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.date121401_tmdb.R

/**
 * Popular List Fragment.
 */
class PopularListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_list, container, false)
    } // end onCreateView().

} // end PopularListFragment.