package com.testdemo.repository

import com.testdemo.model.Post
import com.testdemo.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getPost():Flow<Post> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)

}