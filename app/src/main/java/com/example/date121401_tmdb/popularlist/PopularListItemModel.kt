package com.example.date121401_tmdb.popularlist

data class PopularListItemModel(
    val id: Int,
    val title: String,
    val imgSrc: String,
    val dateMin: String,
    val runTime: String,
    val rate: String
)


val PuplarListDataSource1: List<PopularListItemModel> = listOf(
    PopularListItemModel(1, "Movie 1", "img 1", "date min1", "run time1", "rate1"),
    PopularListItemModel(2, "Movie 2", "img 2", "date min2", "run time2", "rate2"),
    PopularListItemModel(3, "Movie 3", "img 3", "date min3", "run time3", "rate3"),
    PopularListItemModel(4, "Movie 4", "img 4", "date min4", "run time4", "rate4"),
    PopularListItemModel(5, "Movie 5", "img 5", "date min5", "run time5", "rate5"),
)