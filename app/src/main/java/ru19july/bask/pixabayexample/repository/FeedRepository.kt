package ru19july.bask.pixabayexampl.repository

import ru19july.bask.pixabayexampl.api.PixabayService
import javax.inject.Inject

class FeedRepository @Inject constructor(
    private val pixabayService: PixabayService
) {

    suspend fun search(query: String) = pixabayService.search(
        apiKey = "24517168-f6b69e88a6c8ab9c91f5f80fc",
        query = query
    )
}