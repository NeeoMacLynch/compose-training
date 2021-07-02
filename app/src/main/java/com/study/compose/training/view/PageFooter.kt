package com.study.compose.training.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.training.util.getDateTime

/**
 * @author: lynch
 * 页尾
 * */
@Composable
fun PageFooter(name: String, paddingStart: Int, textColor: Color) {
    Column(
        Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = getDateTime(),
                style = typography.body2,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start),
                color = textColor,
            )

            Text(
                text = "您好 $name",
                style = typography.body2,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = paddingStart.dp)
                    .wrapContentWidth(Alignment.End),
                color = textColor,
            )
        }
    }
}

@Preview
@Composable
fun PreviewGreeting(){
    PageFooter(name = "登录者", 0, Color.White)
}
