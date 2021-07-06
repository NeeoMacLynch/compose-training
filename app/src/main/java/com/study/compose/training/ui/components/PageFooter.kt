package com.study.compose.training.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.training.utils.getDateTime

/**
 * @author: lynch
 * 页尾
 * */
@Composable
fun PageFooter() {

    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = getDateTime(),
            style = typography.caption,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start),
        )
    }
}

@Preview
@Composable
fun PreviewGreeting(){
    PageFooter()
}
