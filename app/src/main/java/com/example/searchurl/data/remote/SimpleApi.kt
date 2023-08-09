package com.example.searchurl.data.remote

import com.example.searchurl.data.model.PostsItem
import com.example.searchurl.utils.Constance
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET(value = Constance.END_POINT)
    suspend fun getPosts(): Response<PostsItem>
    @GET(value = "/posts/{postNumber}")
    suspend fun getPostsNumber(@Path("postNumber") number: Int): Response<PostsItem>
}