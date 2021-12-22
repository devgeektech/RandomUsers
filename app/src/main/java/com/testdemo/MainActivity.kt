package com.testdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat


import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.testdemo.adapter.PostAdapter
import com.testdemo.adapter.AdapterCallback
import com.testdemo.model.Result
import com.testdemo.utils.ApiState
import com.testdemo.viewmodel.MainViewModel
import com.testdemo.base.BaseUtil
import com.testdemo.databinding.MainActivityBinding

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.testdemo.databinding.EachRowBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AdapterCallback {

    private lateinit var binding: MainActivityBinding

    private lateinit var PostAdapter: PostAdapter

    private val mainViewModel: MainViewModel by  viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initRecyclerview()

        mainViewModel.getPost()

        lifecycleScope.launchWhenStarted {
            mainViewModel._postStateFlow.collect {it->
                when(it){
                    is ApiState.Loading->{
                        binding.recyclerview.isVisible=false
                        binding.progressBar.isVisible=true
                    }
                    is ApiState.Failure -> {
                        binding.recyclerview.isVisible = false
                        binding.progressBar.isVisible = false
                    }
                    is ApiState.Success->{
                        binding.recyclerview.isVisible = true
                        binding.progressBar.isVisible = false
                        PostAdapter.setData(it.data.results!!)
                        PostAdapter.notifyDataSetChanged()
                    }
                    is ApiState.Empty->{

                    }
                }
            }
        }

    }
    private fun initRecyclerview() {
        PostAdapter= PostAdapter(ArrayList(),this,this)
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=PostAdapter
        }
    }


    override fun onItemClick(position: Int, item: Result,imageView: ImageView,name :TextView,eachRowBinding: EachRowBinding) {
         var intent=Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(getString(R.string.detail),BaseUtil.jsonFromModel(item))
        intent.putExtra(getString(R.string.image), item.picture!!.large)

        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this@MainActivity,
            Pair<View, String>(
                imageView,
                getString(R.string.profile)
            ),
            Pair<View, String>(
                name,
                getString(R.string.name)
            ),Pair<View, String>(
                name,
                getString(R.string.name_main)
            ),
            Pair<View, String>(
                        eachRowBinding.txtNumber,
                getString(R.string.number)
        ), Pair<View, String>(
                eachRowBinding.txtEmail,
                getString(R.string.email)
            ), Pair<View, String>(
                eachRowBinding.txtLocation,
                getString(R.string.loc)
            ),
        )

        ActivityCompat.startActivity(this,intent,activityOptions.toBundle())

    }


}