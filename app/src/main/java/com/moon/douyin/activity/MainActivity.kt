package com.moon.douyin.activity

import android.content.Intent
import com.moon.douyin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        super.initListener()
        viewBinding.btnNoUi.setOnClickListener {
            startActivity(Intent(this, VideoActivity::class.java))
        }
    }
}