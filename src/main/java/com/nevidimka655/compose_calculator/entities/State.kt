package com.nevidimka655.compose_calculator.entities

data class State(
    val number1: String = "",
    val number2: String = "",
    val operation: Operation? = null
)