package com.example.searchurl.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchurl.data.model.PostsItem
import com.example.searchurl.data.repository.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostsViewModel(private val repository: PostsRepository) : ViewModel() {
    val postResponse: MutableLiveData<Response<PostsItem>> = MutableLiveData()
    val PostNumberResponse: MutableLiveData<Response<PostsItem>> = MutableLiveData()
    fun getPosts() {
        viewModelScope.launch {
            val response: Response<PostsItem> = repository.getPosts()
            postResponse.value = response
        }
    }

    fun getPostsNumber(postNumber: Int) {
        viewModelScope.launch {
            val response: Response<PostsItem> = repository.getPostsNumber(postNumber)
            PostNumberResponse.value = response
        }
    }
}