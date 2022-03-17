package com.gapo.gapoproject.presentation.ui.fragment.detail

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.fragment.app.viewModels
import com.gapo.gapoproject.databinding.FragmentNewFeedDetailBinding
import com.gapo.gapoproject.presentation.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewFeedDetailFragment : BaseFragment<FragmentNewFeedDetailBinding>() {
    private val detailViewModel: NewFeedDetailViewModel by viewModels()

    override fun getViewBinding() = FragmentNewFeedDetailBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.getNewFeedDetail.observe(viewLifecycleOwner) { it ->
            it?.run {
                mBinding.tvTitle.text = title
                mBinding.tvDesc.text = description
                publisher?.icon?.takeIf { it.isNotEmpty() }?.also {
                    mBinding.imgView.setImageBitmap(decode(it))
                }
            }
        }
    }

        private fun decode(encodedImage: String): Bitmap? {
            return try {
                val str = encodedImage.split(",").getOrNull(1)
                val decodedString: ByteArray = Base64.decode(str, Base64.DEFAULT)
                BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
            } catch (e: Throwable) {
                null
            }
        }
    }