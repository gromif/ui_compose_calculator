package com.nevidimka655.compose_calculator.entities

sealed class Operation(val symbol: String) {
    object Add: Operation("+")
    object Subtract: Operation("-")
    object Multiply: Operation("×")
    object Divide: Operation("/")
}