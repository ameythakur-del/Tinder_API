package com.example.tinder_api.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tinder_api.R
import com.example.tinder_api.database.room.model.Id
import com.example.tinder_api.database.room.model.Name
import com.example.tinder_api.database.room.model.Result
import com.example.tinder_api.databinding.ResultBinding
import com.squareup.picasso.Picasso

class MainAdapter(val clickListener: ResultListener, val clickListener2: ResultListener) : ListAdapter<Result,
        MainAdapter.ViewHolder>(ResultDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)

        holder.bind(clickListener, clickListener2, getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ResultBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) {
           var imageUrl = result.picture.large

            Picasso.get().load(imageUrl).into(binding.imageView);
        }

        fun bind(clickListener: ResultListener, clickListener2: ResultListener, item: Result) {
            binding.result = item
            binding.clickListener = clickListener
            binding.clickListener2 = clickListener2
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ResultBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    class ResultDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    class ResultListener(val clickListener: (result: Result) -> Unit) {
        fun onClick(result: Result) = clickListener(result)
    }
}