package com.study.compose.training.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * lynch
 * */
@Composable
fun Greeting(name: String) {
    MaterialTheme {
        Text(
            text = "您好 $name",
            style = typography.body2,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewGreeting(){
    Greeting(name = "登录者")
}
