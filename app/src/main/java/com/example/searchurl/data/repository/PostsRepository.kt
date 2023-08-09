package com.example.searchurl.data.repository

import com.example.searchurl.data.model.PostsItem
import com.example.searchurl.data.remote.RetrofitInstance
import retrofit2.Response

class PostsRepository {
    suspend fun getPosts(): Response<PostsItem> = RetrofitInstance.api.getPosts()
    suspend fun getPostsNumber(postNumber: Int): Response<PostsItem> =
        RetrofitInstance.api.getPostsNumber(postNumber)
}