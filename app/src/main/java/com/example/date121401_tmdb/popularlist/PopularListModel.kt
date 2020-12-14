package com.example.date121401_tmdb.popularlist

data class PopularListModel(
    val id: Int,
    val title: String,
)


val puplarListDataSource1: List<PopularListModel> = listOf(
    PopularListModel(1, "Movie 1"),
    PopularListModel(2, "Movie 2"),
    PopularListModel(3, "Movie 3"),
    PopularListModel(4, "Movie 4"),
    PopularListModel(5, "Movie 5"),
)