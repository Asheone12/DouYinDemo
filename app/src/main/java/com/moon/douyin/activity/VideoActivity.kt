package com.moon.douyin.activity

import com.moon.douyin.adapter.ItemViewPagerAdapter
import com.moon.douyin.databinding.ActivityVideoBinding

class VideoActivity : BaseActivity<ActivityVideoBinding>() {
    private lateinit var mPagerAdapter: ItemViewPagerAdapter
    private val urlList = mutableListOf(
        "https://stream7.iqilu.com/10339/upload_transcode/202002/18/20200218114723HDu3hhxqIT.mp4",
        "http://47.97.100.102:40008/app-api/video/file/download?fileName=/flv/TIKTOK/2025-05-08/default/dfcbddc695f7.flv&imeiAndImsi=001068000000006_460004181339999&appType=2",
        "https://stream7.iqilu.com/10339/upload_transcode/202002/18/20200218093206z8V1JuPlpe.mp4",
        "https://stream7.iqilu.com/10339/article/202002/18/2fca1c77730e54c7b500573c2437003f.mp4",
        "https://stream7.iqilu.com/10339/upload_transcode/202002/18/20200218025702PSiVKDB5ap.mp4",
        "https://stream7.iqilu.com/10339/upload_transcode/202002/18/202002181038474liyNnnSzz.mp4"
    )

    override fun onCreateViewBinding(): ActivityVideoBinding {
        return ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        mPagerAdapter = ItemViewPagerAdapter(this, urlList)
        viewBinding.viewPager.adapter = mPagerAdapter
    }
}