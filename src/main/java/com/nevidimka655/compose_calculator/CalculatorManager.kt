package com.nevidimka655.compose_calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nevidimka655.compose_calculator.entities.Action
import com.nevidimka655.compose_calculator.entities.Operation
import com.nevidimka655.compose_calculator.entities.State
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

open class CalculatorManager {
    private val mutex = Mutex()
    var state by mutableStateOf(State())

    suspend fun onAction(action: Action) = mutex.withLock {
        when (action) {
            is Action.Number -> enterNumber(action.number)
            is Action.Delete -> delete()
            is Action.Clear -> state = State()
            is Action.Operation -> enterOperation(action.operation)
            is Action.Decimal -> enterDecimal()
            is Action.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: Operation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    open suspend fun calculate() {
        val number1 = state.number1.toBigDecimalOrNull()
        val number2 = state.number2.toBigDecimalOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is Operation.Add -> number1 + number2
                is Operation.Subtract -> number1 - number2
                is Operation.Multiply -> number1 * number2
                is Operation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(number1 = state.number1 + ".")
            return
        } else if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        const val MAX_NUM_LENGTH = 8
    }

}