package ru19july.bask.pixabayexampl.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru19july.bask.pixabayexampl.api.data.SearchResponse
import ru19july.bask.pixabayexampl.repository.FeedRepository
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: FeedRepository
): ViewModel() {

    private val _response = MutableLiveData<SearchResponse>()
    val response: LiveData<SearchResponse> = _response

    fun search(query: String) {
        viewModelScope.launch {
            _response.value = repository.search(query = query)
        }
    }
}