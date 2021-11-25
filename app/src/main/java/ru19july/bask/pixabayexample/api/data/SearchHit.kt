package ru19july.bask.pixabayexampl.api.data

data class SearchHit(
    val id: String,
    val largeImageURL: String,
    val imageURL: String?,
    val imageWidth: Int,
    val imageHeight: Int,
)