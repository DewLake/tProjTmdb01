package com.example.date121401_tmdb.popularlist

import com.example.date121401_tmdb.webapi.TmdbRepository
import com.example.date121401_tmdb.webapi.model.moviedetail.MovieDetailResponse
import com.example.date121401_tmdb.webapi.model.popular.GetPopularResponse
import com.example.date121401_tmdb.webapi.model.popular.Result

data class PopularListItemModel(
    val id: Int,
    val title: String,
    val imgSrc: String,
    val dateMin: String,
    val runTime: String,
    val popularity: Int
){
    companion object {
        /** MovieDetailResponse */
        fun from(movieDetail: MovieDetailResponse): PopularListItemModel {
            val md = movieDetail
            return PopularListItemModel(
                    md.id,
                    md.title,
                    md.backdrop_path,
                    md.release_date,
                    md.runtime.toString(),
                    (md.vote_average*10).toInt(),
            )
        }

        /** MovieDetailResponse.Result */
        fun from(result: Result): PopularListItemModel {
            val sr = result
            return PopularListItemModel(
                    sr.id,
                    sr.title,
                    sr.backdrop_path,
                    sr.release_date,
                    "113",      // TODO(應由 movie detail 查詢)
                    (sr.vote_average*10).toInt()
            )
        }
    } // end companion object.
} // end data class PopularListItemModel.


class PopularListModel() {

    companion object {
        /**
         * Get Popular List from GetPopularResponse.
         */
        fun from(response: GetPopularResponse): List<PopularListItemModel>{
            // prepare target list.
            val populist = mutableListOf<PopularListItemModel>()

            // get ids from response result
            /* Response Schema:
                data class GetPopularResponse(
                    val page: Int,
                    val results: List<Result>,
                    val total_pages: Int,
                    val total_results: Int
                )
             */

            for (item in response.results) {
                populist.add(
                        PopularListItemModel.from(item)
                )
            }

            return populist.toList()
        } // end from().

    } // companion object.

} // end class PopularListModel().


val PuplarListDataSource1: List<PopularListItemModel> = listOf(
    PopularListItemModel(1, "Movie 1", "img1", "date min1", "run time1", 15),
    PopularListItemModel(2, "Movie 2", "img2", "date min2", "run time2", 25),
    PopularListItemModel(3, "Movie 3", "img3", "date min3", "run time3", 35),
    PopularListItemModel(4, "Movie 4", "img4", "date min4", "run time4", 45),
    PopularListItemModel(5, "Movie 5", "img5", "date min5", "run time5", 55),
)