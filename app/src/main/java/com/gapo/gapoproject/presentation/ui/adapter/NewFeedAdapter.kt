package com.gapo.gapoproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.gapo.gapoproject.R
import com.gapo.gapoproject.databinding.ItemNewFeedBinding
import com.gapo.gapoproject.domain.model.NewFeed
import com.gapo.gapoproject.presentation.common.BaseRecyclerAdapter
import com.gapo.gapoproject.presentation.model.NewFeedUIModel

class NewFeedAdapter(private val navigateToDetail: () -> Unit) :
    BaseRecyclerAdapter<NewFeedUIModel, ItemNewFeedBinding>(
        callBack = object : DiffUtil.ItemCallback<NewFeedUIModel>() {
            override fun areItemsTheSame(oldItem: NewFeedUIModel, newItem: NewFeedUIModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NewFeedUIModel, newItem: NewFeedUIModel): Boolean {
                return false
            }
        }) {
    override fun bind(binding: ItemNewFeedBinding, item: NewFeedUIModel) {
        binding.tvTitle.text = item.title
        binding.tvDesc.text = item.description

        Glide
            .with(binding.root.context)
            .load(item.images?.getOrNull(0)?.href)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgView)

        binding.root.setOnClickListener {
            navigateToDetail.invoke()
        }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int?): ItemNewFeedBinding {
        return ItemNewFeedBinding.inflate(LayoutInflater.from(parent.context))
    }
}