package com.nevidimka655.compose_calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.nevidimka655.compose_calculator.Calculator
import kotlinx.coroutines.launch

@Composable
fun Calculator.Buttons.Button(
    symbol: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    textStyle: TextStyle = TextStyle(),
    onClick: suspend () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = {
                coroutineScope.launch {
                    onClick()
                }
            })
            .then(modifier)
    ) {
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 26.sp,
            color = textColor
        )
    }
}

@Composable
fun Calculator.Buttons.ButtonTertiary(
    symbol: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    onClick: suspend () -> Unit
) = Button(
    symbol = symbol,
    modifier = modifier,
    backgroundColor = MaterialTheme.colorScheme.tertiary,
    textColor = MaterialTheme.colorScheme.onTertiary,
    textStyle = textStyle,
    onClick = onClick
)

@Composable
fun Calculator.Buttons.ButtonSecondary(
    symbol: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    onClick: suspend () -> Unit
) = Button(
    symbol = symbol,
    modifier = modifier,
    backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
    textColor = MaterialTheme.colorScheme.onSecondaryContainer,
    textStyle = textStyle,
    onClick = onClick
)