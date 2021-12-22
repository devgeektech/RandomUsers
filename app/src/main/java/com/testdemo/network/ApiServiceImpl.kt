package com.testdemo.network

import com.testdemo.model.Post
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost():Post = apiService.getPost()
}