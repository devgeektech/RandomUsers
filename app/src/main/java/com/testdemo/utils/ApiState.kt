package com.testdemo.utils

import com.testdemo.model.Post


sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:Post) : ApiState()
    object Empty : ApiState()
}
