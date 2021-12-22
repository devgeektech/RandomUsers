package com.testdemo.network

import com.testdemo.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("?results=200")
   suspend fun getPost(): Post

}