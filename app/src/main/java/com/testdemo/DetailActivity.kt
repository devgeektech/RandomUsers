package com.testdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.testdemo.model.Result
import com.testdemo.base.BaseUtil
import com.testdemo.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var result: Result? = null;
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.setHomeButtonEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        ViewCompat.setTransitionName(binding.imageView, getString(R.string.profile))
        ViewCompat.setTransitionName(binding.tvName, getString(R.string.name_main))
        ViewCompat.setTransitionName(binding.nameValue, getString(R.string.name))
        ViewCompat.setTransitionName(binding.txtEmail, getString(R.string.email))
        ViewCompat.setTransitionName(binding.txtNumber, getString(R.string.number))
        ViewCompat.setTransitionName(binding.txtLocation, getString(R.string.loc))
        var intentData = intent.getStringExtra(getString(R.string.detail))
        result = BaseUtil.objectFromString(intentData!!, Result::class.java)
        if (result != null)
            setData(result!!)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            android.R.id.home -> {

                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun setData(result: Result) {
        Glide.with(this).load(intent.getStringExtra(getString(R.string.image)))
            .placeholder(R.drawable.img).into(binding.imageView);
        binding.nameValue.text = result.name!!.first.plus(" ").plus(result.name.last)
        binding.tvName.text = result.name!!.first.plus(" ").plus(result.name.last)
        binding.txtUsername.text = result.login!!.username
        binding.txtNumber.text = result.phone
        binding.txtEmail.text = result.email
        binding.txtLocation.text = result.location!!.street!!.name.plus(getString(R.string.space))
            .plus(result!!.location!!.city).plus(R.string.space)
            .plus(result!!.location!!.state).plus(R.string.space)
            .plus(result!!.location!!.country).plus(R.string.space)
            .plus(result!!.location!!.postcode)
        binding.dobValue.text = BaseUtil.convertDateTime(result.dob!!.date!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAfterTransition()
    }


}