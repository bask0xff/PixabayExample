package ru19july.bask.pixabayexampl.api.data

data class SearchResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<SearchHit>,
)