package com.testdemo.adapter

import android.widget.ImageView
import android.widget.TextView
import com.testdemo.model.Result
import com.testdemo.databinding.EachRowBinding

interface AdapterCallback {
    fun onItemClick(position:Int,Item: Result,imageView:ImageView,name:TextView,binding: EachRowBinding)
}