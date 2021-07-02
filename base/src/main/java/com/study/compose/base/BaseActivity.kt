package com.study.compose.base

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity

/**
 * @author limingqi
 * */
open class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (!getDarkModeStatus(this)) initStatusBar()
    }

    /**
     * 获取系统黑暗模式状态
     * */
    private fun getDarkModeStatus(context: Context): Boolean {
        val mode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return mode == Configuration.UI_MODE_NIGHT_YES
    }

    /**
     * 初始化顶部状态栏
     */
    protected open fun initStatusBar() {
        //默认顶部状态栏字体为黑色,如需改变颜色,子类覆写此方法,不使用super, 重新调用setNativeStatusBar
        //这样是为了解决setNativeStatusBar方法重复调用的问题
        setNativeStatusBar(StateBarType.DARK)
    }

    /**
     * 状态栏(展示信号区域)状态
     */
    protected enum class StateBarType {
        LIGHT, DARK, TRAN
    }

    /**
     * 设置顶栏文字颜色
     */
    protected open fun setNativeStatusBar(type: StateBarType?) {
        val window = this.window
        val decor = window.decorView
        when (type) {
            StateBarType.DARK -> decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            StateBarType.LIGHT -> decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            StateBarType.TRAN -> {
                //https://www.jianshu.com/p/e89ee0a77bb5
                //View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN设置全屏，顶栏展示图片的时候会用到
                //decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                decor.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            }
        }
    }
}