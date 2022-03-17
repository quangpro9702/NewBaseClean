package com.gapo.gapoproject.presentation.ui.fragment.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gapo.gapoproject.databinding.FragmentNewsFeedBinding
import com.gapo.gapoproject.presentation.common.BaseFragment
import com.gapo.gapoproject.presentation.ui.adapter.NewFeedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFeedFragment : BaseFragment<FragmentNewsFeedBinding>() {
    val viewModel: NewsFeedViewModel by viewModels()

    var adapter: NewFeedAdapter? = null

    override fun getViewBinding() = FragmentNewsFeedBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewFeedAdapter {
            findNavController().navigate(NewsFeedFragmentDirections.actionMainFragmentToDetailFragment())
        }.apply {
            mBinding.recyclerNewsFeed.adapter = this
        }

        viewModel.getNewsFeed.observe(viewLifecycleOwner) {
            adapter?.submitList(it?.items?.toMutableList())
        }
    }
}