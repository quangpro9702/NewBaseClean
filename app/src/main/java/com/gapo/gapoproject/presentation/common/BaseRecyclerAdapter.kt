package com.gapo.gapoproject.presentation.common

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.util.concurrent.Executors

abstract class BaseRecyclerAdapter<T, VB : ViewBinding>(
    callBack: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<VB>>(
    AsyncDifferConfig.Builder(callBack)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(createBinding(parent = parent, viewType = viewType))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        bind(holder.binding, getItem(position))
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int? = 0): VB

    protected abstract fun bind(binding: VB, item: T)
}

class BaseViewHolder<out T : ViewBinding> constructor(val binding: T) :
    RecyclerView.ViewHolder(binding.root)
