package com.study.compose.training

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat

/**
 * @author lynch
 * */
open class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //启用全面屏
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        refreshDarkModeState(newConfig = newConfig)
    }

    private fun refreshDarkModeState(newConfig: Configuration) {
        when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {

            } // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {

            } // Night mode is active, we're using dark theme
        }
    }
}