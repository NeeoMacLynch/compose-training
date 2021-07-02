package com.study.compose.training.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.training.R
import com.study.compose.training.util.DarkColors
import com.study.compose.training.util.LightColors

/**
 * @author lynch
 * */
@Composable
fun NewsStory(greetingName: String, title: String) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(4.dp))
                    .height(180.dp)
                    .background(colors.primary)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_hero),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                style = typography.h4,
                fontWeight = FontWeight.Bold,
                color = colors.onSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "这里包括一些 Composable " +
                        "以及一些 Jetpack 新特性的练习" +
                        "欢迎学习或者提出宝贵意见",
                style = typography.body1,
                color = colors.onSecondary
            )

            PageFooter(name = greetingName, paddingStart = 16, colors.onSecondary)
        }
    }
}

@Preview
@Composable
fun PreviewNewStory() {
    NewsStory("登录者", "标题")
}