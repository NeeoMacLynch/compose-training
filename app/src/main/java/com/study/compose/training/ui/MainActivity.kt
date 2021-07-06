package com.study.compose.training.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import com.study.compose.training.BaseActivity
import com.study.compose.training.R
import com.study.compose.training.model.EasyCardBean
import com.study.compose.training.ui.home.HomeScreen

/**
 * @author lynch
 * */
class MainActivity : BaseActivity() {
    private val easyCards by lazy {
        setOf(
            EasyCardBean(
                "欢迎光临",
                "这里是我的一些博客文章，希望您喜欢",
                R.drawable.ic_android_for_developers
            ),
            EasyCardBean(
                "Compose 练习",
                "这个 APP 使用 Jetpack Compose 编写，" +
                        "在这里我会尽可能多的使用 Kotlin 以及 Jetpack 的一些特性，" +
                        "可能会出些一些奇奇怪怪的功能，" +
                        "敬请谅解",
                R.drawable.ic_hero
            ),
            EasyCardBean(
                "第一阶段计划",
                "通过 Compose 搭建基本布局框架",
                R.drawable.ic_android_design_skills
            ),
            EasyCardBean(
                "第二阶段计划",
                "将 Blog 中文章的 MarkDown 拉取到本地并解析成 HTML 展示",
                R.drawable.ic_android_new_programmers
            ),
            EasyCardBean(
                "加油！",
                "",
                null
            ),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen(easyCards)
        }
    }
}