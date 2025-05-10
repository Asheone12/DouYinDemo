package com.moon.douyin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.moon.douyin.databinding.FragmentVideoBinding

class VideoFragment : BaseFragment<FragmentVideoBinding>() {
    override fun onCreateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(inflater, container, false)
    }

    companion object {
        @JvmStatic
        fun getNewInstance(url: String): VideoFragment {
            val fragment = VideoFragment()
            fragment.arguments = bundleOf("url" to url)
            return fragment
        }
    }

    override fun initView() {
        super.initView()
        val url = arguments?.getString("url") ?: ""
        viewBinding.videoPlayer.apply {
            isLooping = true
        }
        viewBinding.videoPlayer.setUp(url, true, "测试视频")
    }

    override fun onResume() {
        super.onResume()
        viewBinding.videoPlayer.onVideoResume()
        viewBinding.videoPlayer.startPlayLogic()
    }

    override fun onPause() {
        super.onPause()
        viewBinding.videoPlayer.onVideoPause()
    }
}