package com.nevidimka655.compose_calculator.entities

sealed class Action {
    data class Number(val number: Int): Action()
    object Clear: Action()
    object Delete: Action()
    data class Operation(val operation: com.nevidimka655.compose_calculator.entities.Operation): Action()
    object Calculate: Action()
    object Decimal: Action()
}