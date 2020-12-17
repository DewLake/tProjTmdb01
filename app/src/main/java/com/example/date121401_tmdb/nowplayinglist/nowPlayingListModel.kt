package com.example.date121401_tmdb.nowplayinglist

data class NowPlayingListModel(
    val id: Int,
    val imgSrc: String,
)


val NowPlayingListDataSource1: List<NowPlayingListModel> = listOf(
    NowPlayingListModel(1, "src1"),
    NowPlayingListModel(2, "src2"),
    NowPlayingListModel(3, "src3"),
    NowPlayingListModel(4, "src4"),
    NowPlayingListModel(5, "src5"),
)