package com.moon.douyin.widget


import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.moon.douyin.R
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer


/**
 * 无任何控制ui的播放
 */
class EmptyControlVideo : StandardGSYVideoPlayer {
    constructor(context: Context, fullFlag: Boolean) : super(context, fullFlag)
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun getLayoutId(): Int {
        return R.layout.empty_control_video
    }

    override fun touchSurfaceMoveFullLogic(absDeltaX: Float, absDeltaY: Float) {
        super.touchSurfaceMoveFullLogic(absDeltaX, absDeltaY)
        //不给触摸快进，如果需要，屏蔽下方代码即可
        mChangePosition = false

        //不给触摸音量，如果需要，屏蔽下方代码即可
        mChangeVolume = false

        //不给触摸亮度，如果需要，屏蔽下方代码即可
        mBrightness = false
    }

    private fun touchDoubleUp(e: MotionEvent?) {
        //super.touchDoubleUp();
        //不需要双击暂停
    }
}