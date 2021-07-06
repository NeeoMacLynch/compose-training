package com.study.compose.training.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.study.compose.training.R
import com.study.compose.training.model.EasyCardBean
import com.study.compose.training.ui.components.InsetAwareTopAppBar
import com.study.compose.training.ui.theme.MyTheme

/**
 * @author lynch
 * 主页布局，
 * 自定义主题，使用 Scaffold 规范化布局
 * 自定义 TopBar，设置 Logo 可点击展开侧栏
 * */
@Composable
fun HomeScreen(easyCards: Set<EasyCardBean>) {
    val coroutineScope = rememberCoroutineScope()

    MyTheme {
        ProvideWindowInsets {
            val systemUiController = rememberSystemUiController()
            val darkMode = isSystemInDarkTheme()

            /**
             * from: https://juejin.cn/post/6930785944580653070
             * 副作用，一个函数的执行过程中，除了返回函数值之外，对调用方还会带来其他附加影响，例如修改全局变量或修改参数等。
             * 声明式 UI 框架如 Compose 会通过函数不断执行来渲染 UI ，因此 Compose 必须使用纯函数也即没有副作用的函数来执行渲染
             * 但是依然可以添加一些副作用在函数执行过程中，要添加这些副作用操作请认准含 Effect 的代码段
             * 请注意，副作用是非常危险的，编写副作用时需要保证：
             *  1.副作用的执行时间是明确的
             *  2.副作用的执行次数是可控的
             *  3.副作用不会造成内存泄漏
             * */

            /**
             * Compose 的生命周期：
             * - onActive（or onEnter）：当Composable首次进入组件树时
             * - onCommit（or onUpdate）：UI随着recomposition发生更新时，也即循环执行
             * - onDispose（or onLeave）：当Composable从组件树移除时
             * */

            //在 onCommit 回调中进行处理
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = !darkMode)
            }

            Scaffold(
                topBar = {
                    val appName = stringResource(R.string.app_name)
                    InsetAwareTopAppBar(
                        title = { Text(appName) },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_dehaze_24),
                                    contentDescription = stringResource(R.string.app_logo),
                                )
                            }
                        }
                    )
                },
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                ) {
                    HomeScreenContent(easyCards)
                }
            }
        }

    }
}

/**
 * 主页内容布局，
 * 使用 LazyColumn 保证多种列表 item 不会影响性能
 * 同时设置内容内边距防止全屏下导航栏与内容重叠
 * */
@Composable
fun HomeScreenContent(easyCards: Set<EasyCardBean>) {
    LazyColumn(
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.systemBars,
            applyTop = false
        ),
    ) {
        item{ ContentList4Easy(easyCards) }
    }
}

/**
 * 文章列表
 * */
@Composable
fun ContentList4Easy(easyCards: Set<EasyCardBean>) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        easyCards.forEach {
            EasyCard(it)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview("Home screen")
@Preview("Home screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNewStory() {
    val easyCards: Set<EasyCardBean> = setOf(
        EasyCardBean("标题1", "标签1", R.drawable.ic_launcher_foreground),
        EasyCardBean("标题2", "标签2", null),
        EasyCardBean("标题3", "标签3", R.drawable.ic_launcher_foreground),
        EasyCardBean("标题4", "标签4", null),
    )
    HomeScreen(easyCards)
}