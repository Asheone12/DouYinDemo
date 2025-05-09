package com.moon.douyin.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    lateinit var viewBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeOnCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        //1. 设置布局
        viewBinding = onCreateViewBinding()
        setContentView(viewBinding.root)
        //2. 布局之后，自定义方法之前，可能需要对Bundle的处理
        afterOnCreateView(savedInstanceState)

        //3.初始化布局与数据
        initStatusBar()
        initView()
        initData()
        initListener()
    }

    /**
     * onCreate时机
     */
    open fun beforeOnCreate(savedInstanceState: Bundle?) {}

    /**
     * afterCreate时机
     */
    open fun afterOnCreateView(savedInstanceState: Bundle?) {}

    /**
     * 创建ViewBinding
     */
    abstract fun onCreateViewBinding(): T

    /**
     * 状态栏操作
     */
    @CallSuper
    open fun initStatusBar() {}

    /**
     * 初始化视图
     */
    @CallSuper
    open fun initView() {}

    /**
     * 初始化数据
     */
    @CallSuper
    open fun initData() {
        observerData()
    }

    /**
     * 绑定viewModel数据方法
     */
    @CallSuper
    open fun observerData() {}
    /**
     * 初始化监听
     */
    @CallSuper
    open fun initListener() {}


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}