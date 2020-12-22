package com.example.date121401_tmdb.nowplayinglist

data class NowPlayingListItemModel(
    val id: Int,
    val imgSrc: String,
)


val NowPlayingListDataSource1: List<NowPlayingListItemModel> = listOf(
    NowPlayingListItemModel(1, "src1"),
    NowPlayingListItemModel(2, "src2"),
    NowPlayingListItemModel(3, "src3"),
    NowPlayingListItemModel(4, "src4"),
    NowPlayingListItemModel(5, "src5"),
)