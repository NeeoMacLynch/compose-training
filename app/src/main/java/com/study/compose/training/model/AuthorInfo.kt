package com.study.compose.training.model

import com.study.compose.training.R

/**
 * @author lynch
 * 一个单例类保存文章作者信息
 * */
enum class AuthorInfo {
    INSTANCE

    {
        val authorName = "Lynch Lee"
        val authorTag = "BIG_BOSS"
        val authorPhoto = R.drawable.ic_android_36
    }
}