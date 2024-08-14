package com.nevidimka655.compose_calculator.ui.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nevidimka655.compose_calculator.ui.Button
import com.nevidimka655.compose_calculator.ui.ButtonSecondary
import com.nevidimka655.compose_calculator.ui.ButtonTertiary
import com.nevidimka655.compose_calculator.ui.Buttons

@Composable
fun Buttons.AC(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.ButtonTertiary(
    symbol = "AC",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.DEL(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.Button(
    symbol = "Del",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.DIVIDE(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.Button(
    symbol = "/",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.MULTIPLY(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.Button(
    symbol = "×",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.SUBTRACT(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.Button(
    symbol = "-",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.ADD(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.Button(
    symbol = "+",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.DECIMAL(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.ButtonSecondary(
    symbol = ".",
    modifier = modifier,
    onClick = onClick
)

@Composable
fun Buttons.EQUAL(modifier: Modifier = Modifier, onClick: suspend () -> Unit) = Buttons.Button(
    symbol = "=",
    modifier = modifier,
    onClick = onClick
)