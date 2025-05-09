package com.moon.douyin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.moon.douyin.fragment.VideoFragment

class ItemViewPagerAdapter(fragmentActivity: FragmentActivity, private val urlList: MutableList<String>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = urlList.size

    override fun createFragment(position: Int): Fragment = VideoFragment.getNewInstance(urlList[position])

}