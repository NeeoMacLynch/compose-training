package com.study.compose.training.util

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val PURPLE_200 = Color(0xFFBB86FC)
private val PURPLE_500 = Color(0xFF6200EE)
private val PURPLE_700 = Color(0xFF3700B3)
private val TEAL_200 = Color(0xFF03DAC5)
private val TEAL_900 = Color(0xFF018786)
private val BLACK = Color(0xFF000000)
private val GRAY = Color(0xFF121212)
private val WHITE = Color(0xFFFFFFFF)
private val RED = Color(0xFFB00020)
private val PINK = Color(0xFFCF6679)

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
    primary = PURPLE_500,
    primaryVariant = PURPLE_700,
    onPrimary = WHITE,
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