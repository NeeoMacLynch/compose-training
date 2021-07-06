package com.study.compose.training.ui.home

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.compose.training.R
import com.study.compose.training.model.EasyCardBean
import com.study.compose.training.ui.theme.MyTheme

/**
 * @author lynch
 * 文章卡片布局
 * */
@Composable
fun EasyCard(easyCardBean: EasyCardBean) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(4.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EasyPhoto(resID = easyCardBean.topImage)
            EasyInfo(easyCardBean)
        }
    }
}

@Composable
fun EasyPhoto(resID: Int?) {
    if (resID == null) {
        Icon(
            painter = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = stringResource(id = R.string.easy_photo),
            tint = MaterialTheme.colors.error,
            modifier = Modifier
                .padding(top = 18.dp)
        )
    }
    else {
        Image(
            painter = painterResource(id = resID),
            contentDescription = stringResource(id = R.string.easy_photo),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(4.dp))
                .fillMaxWidth(),
        )
    }
}

@Composable
fun EasyInfo(easyCardBean: EasyCardBean) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        EasyTitle(easyCardBean.title)
        Spacer(modifier = Modifier.height(4.dp))
        EasyCaption(easyCardBean.caption)
    }
}

@Composable
fun EasyTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun EasyCaption(caption: String) {
    Text(
        text = caption,
        style = MaterialTheme.typography.caption,
    )
}

@Preview("EasyCard")
@Preview("EasyCard (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewEasyCard() {
    MyTheme {
        Surface {
            EasyCard(
                EasyCardBean(
                    "标题",
                    "这里是摘要",
                    null
                )
            )
        }
    }
}