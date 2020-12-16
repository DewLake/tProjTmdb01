package com.example.date121401_tmdb.banner

data class BannerModel(
    val id: Int,
    val imgSrc: String,
)


val BannerDataSource1: List<BannerModel> = listOf(
    BannerModel(1, "src1"),
    BannerModel(2, "src2"),
    BannerModel(3, "src3"),
    BannerModel(4, "src4"),
    BannerModel(5, "src5"),
)