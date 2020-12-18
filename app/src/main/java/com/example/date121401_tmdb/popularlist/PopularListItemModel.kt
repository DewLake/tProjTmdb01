package com.example.date121401_tmdb.popularlist

data class PopularListItemModel(
    val id: Int,
    val title: String,
    val imgSrc: String,
    val dateMin: String,
    val runTime: String,
    val popularity: Int
)


val PuplarListDataSource1: List<PopularListItemModel> = listOf(
    PopularListItemModel(1, "Movie 1", "img 1", "date min1", "run time1", 15),
    PopularListItemModel(2, "Movie 2", "img 2", "date min2", "run time2", 25),
    PopularListItemModel(3, "Movie 3", "img 3", "date min3", "run time3", 35),
    PopularListItemModel(4, "Movie 4", "img 4", "date min4", "run time4", 45),
    PopularListItemModel(5, "Movie 5", "img 5", "date min5", "run time5", 55),
)