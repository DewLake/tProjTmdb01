package com.example.date121401_tmdb.popularlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.date121401_tmdb.R

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

    ////////// IClickItemPerformer
    private val itemClickedPerformer = PopularListAdapter.IItemClickedPerformer {
        print("a")
    }

    /**
     * Popular List Recycler view initialize.
     */
    fun initPopularListRecyclerView(view: View) {
        this.rcvPopularList = view.findViewById<RecyclerView>(R.id.rcvPopularList).apply {
            adapter = PopularListAdapter(PuplarListDataSource1)
        }
    }

} // end PopularListFragment.