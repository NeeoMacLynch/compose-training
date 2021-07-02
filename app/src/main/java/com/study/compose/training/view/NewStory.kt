package com.study.compose.training.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.training.R

@Composable
fun NewsStory() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(2.5.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                style = typography.h6,
                color = Color.White
            )

            Text(
                "Davenport, California",
                style = typography.body2,
                color = Color.White
            )
            Text(
                "December 2018",
                style = typography.body1,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PreviewNewStory() {
    NewsStory()
}