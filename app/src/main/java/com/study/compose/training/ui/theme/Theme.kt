package com.study.compose.training.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


val DarkColors = darkColors(
    primary = PURPLE_200,
    primaryVariant = PURPLE_700,
    onPrimary = BLACK,
    secondary = TEAL_200,
    secondaryVariant = TEAL_200,
    onSecondary = BLACK,
    background = GRAY,
    surface = GRAY,
    error = PINK,
    onBackground = WHITE,
    onSurface = WHITE,
    onError = BLACK,
)
val LightColors = lightColors(
    primary = WHITE,
    primaryVariant = WHITE,
    onPrimary = BLACK,
    secondary = TEAL_200,
    secondaryVariant = TEAL_900,
    onSecondary = BLACK,
    background = WHITE,
    surface = WHITE,
    error = RED,
    onBackground = BLACK,
    onSurface = BLACK,
    onError = WHITE,
)

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
//        typography = MyTypography,
//        shapes = MyShapes,
        content = content
    )
}
