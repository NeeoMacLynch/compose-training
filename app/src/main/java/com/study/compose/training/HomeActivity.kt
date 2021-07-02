package com.study.compose.training

import android.os.Bundle
import androidx.activity.compose.setContent
import com.study.compose.base.BaseActivity
import com.study.compose.training.view.NewsStory

/**
 * @author lynch
 * */
class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory("Lynch Lee", "Compose 练习")
        }
    }
}