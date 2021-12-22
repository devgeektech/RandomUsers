package com.testdemo.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.testdemo.model.Result
import com.testdemo.R
import com.testdemo.databinding.EachRowBinding

class PostAdapter(private var postList: List<Result>, callback: AdapterCallback, private var  activity: Activity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var mCallback: AdapterCallback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
     var    binding = EachRowBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class PostViewHolder(val binding: EachRowBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            setIsRecyclable(false)
            itemView.setOnClickListener {
                mCallback.onItemClick(
                    adapterPosition, postList[adapterPosition],binding.imgUser,binding.txtName,binding
                )
            }
        }

        fun bind(item: Result) {
            binding.apply {
                var name=item.name!!;
                txtName.text=name.first.plus(" ").plus(name.last)
                txtEmail.text=item.email.toString().lowercase()
                txtLocation.text=item.location!!.street!!.name.plus(",").plus(item!!.location!!.city)
                txtNumber.text=item.phone
                Glide.with(activity).load(item.picture!!.large).placeholder(R.drawable.img).into(binding.imgUser);
                binding.imgUser.animation = AnimationUtils.loadAnimation(
                    activity,
                    R.anim.fade_transition
                )
                binding.clickCardView.animation = AnimationUtils.loadAnimation(
                    activity,
                    R.anim.fade_scale
                )
            }
        }
    }

    fun setData(postList: List<Result>) {
        this.postList=postList
        notifyDataSetChanged()
    }

}