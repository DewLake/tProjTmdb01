package com.example.date121401_tmdb.popularlist

data class PopularListItemModel(
    val id: Int,
    val title: String,
)


val PuplarListDataSource1: List<PopularListItemModel> = listOf(
    PopularListItemModel(1, "Movie 1"),
    PopularListItemModel(2, "Movie 2"),
    PopularListItemModel(3, "Movie 3"),
    PopularListItemModel(4, "Movie 4"),
    PopularListItemModel(5, "Movie 5"),
)