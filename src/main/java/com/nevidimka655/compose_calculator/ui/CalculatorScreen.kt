package com.nevidimka655.compose_calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nevidimka655.compose_calculator.Calculator
import com.nevidimka655.compose_calculator.CalculatorManager
import io.gromif.astracrypt.calculator.domain.Action
import io.gromif.astracrypt.calculator.domain.Operation
import com.nevidimka655.compose_calculator.ui.buttons.AC
import com.nevidimka655.compose_calculator.ui.buttons.ADD
import com.nevidimka655.compose_calculator.ui.buttons.DECIMAL
import com.nevidimka655.compose_calculator.ui.buttons.DEL
import com.nevidimka655.compose_calculator.ui.buttons.DIVIDE
import com.nevidimka655.compose_calculator.ui.buttons.EIGHT
import com.nevidimka655.compose_calculator.ui.buttons.EQUAL
import com.nevidimka655.compose_calculator.ui.buttons.FIVE
import com.nevidimka655.compose_calculator.ui.buttons.FOUR
import com.nevidimka655.compose_calculator.ui.buttons.MULTIPLY
import com.nevidimka655.compose_calculator.ui.buttons.NINE
import com.nevidimka655.compose_calculator.ui.buttons.ONE
import com.nevidimka655.compose_calculator.ui.buttons.SEVEN
import com.nevidimka655.compose_calculator.ui.buttons.SIX
import com.nevidimka655.compose_calculator.ui.buttons.SUBTRACT
import com.nevidimka655.compose_calculator.ui.buttons.THREE
import com.nevidimka655.compose_calculator.ui.buttons.TWO
import com.nevidimka655.compose_calculator.ui.buttons.ZERO
import com.nevidimka655.ui.compose_core.ext.LocalWindowHeight
import com.nevidimka655.ui.compose_core.ext.isCompact
import com.nevidimka655.ui.compose_core.theme.spaces

@Preview
@Composable
fun Calculator.Screen.Auto(calculatorManager: CalculatorManager = CalculatorManager()) {
    if (LocalWindowHeight.current.isCompact) Horizontal(calculatorManager)
    else Vertical(calculatorManager)
}

@Composable
fun Calculator.Screen.Horizontal(calculatorManager: CalculatorManager = CalculatorManager()) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(MaterialTheme.spaces.spaceMedium)
) {
    val state = calculatorManager.state
    val buttonSpacing = MaterialTheme.spaces.spaceSmall
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
    ) {
        SelectionContainer(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                fontWeight = FontWeight.Light,
                fontSize = 52.sp,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 52.sp,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(2f),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Calculator.Buttons.AC(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Clear)
                }
                Calculator.Buttons.DEL(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Delete)
                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Calculator.Buttons.DIVIDE(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Operation(Operation.Divide))
                }
                Calculator.Buttons.MULTIPLY(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Operation(Operation.Multiply))
                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Calculator.Buttons.SUBTRACT(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Operation(Operation.Subtract))
                }
                Calculator.Buttons.ADD(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Operation(Operation.Add))
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.SEVEN(modifier = Modifier.weight(1f)) {
                calculatorManager.onAction(Action.Number(7))
            }
            Calculator.Buttons.EIGHT(modifier = Modifier.weight(1f)) {
                calculatorManager.onAction(Action.Number(8))
            }
            Calculator.Buttons.NINE(modifier = Modifier.weight(1f)) {
                calculatorManager.onAction(Action.Number(9))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.FOUR(modifier = Modifier.weight(1f)) {
                calculatorManager.onAction(Action.Number(4))
            }
            Calculator.Buttons.FIVE(modifier = Modifier.weight(1f)) {
                calculatorManager.onAction(Action.Number(5))
            }
            Calculator.Buttons.SIX(modifier = Modifier.weight(1f)) {
                calculatorManager.onAction(Action.Number(6))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Calculator.Buttons.ZERO(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Number(0))
                }
                Calculator.Buttons.ONE(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Number(1))
                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Calculator.Buttons.TWO(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Number(2))
                }
                Calculator.Buttons.THREE(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Number(3))
                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Calculator.Buttons.DECIMAL(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Decimal)
                }
                Calculator.Buttons.EQUAL(modifier = Modifier.weight(1f)) {
                    calculatorManager.onAction(Action.Calculate)
                }
            }
        }
    }
}

@Composable
fun Calculator.Screen.Vertical(calculatorManager: CalculatorManager = CalculatorManager()) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(MaterialTheme.spaces.spaceMedium),
    Arrangement.Bottom
) {
    val defaultModifier = remember {
        Modifier
            .aspectRatio(1f)
            .weight(1f)
    }
    val state = calculatorManager.state
    val buttonSpacing = MaterialTheme.spaces.spaceSmall
    SelectionContainer(modifier = Modifier.align(Alignment.End)) {
        Text(
            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
            fontWeight = FontWeight.Light,
            fontSize = 52.sp,
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = 52.sp,
            textAlign = TextAlign.End,
            maxLines = 3
        )
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.AC(
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f)
            ) {
                calculatorManager.onAction(Action.Clear)
            }
            Calculator.Buttons.DEL(
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f)
            ) {
                calculatorManager.onAction(Action.Delete)
            }
            Calculator.Buttons.DIVIDE(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Operation(Operation.Divide))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.SEVEN(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(7))
            }
            Calculator.Buttons.EIGHT(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(8))
            }
            Calculator.Buttons.NINE(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(9))
            }
            Calculator.Buttons.MULTIPLY(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Operation(Operation.Multiply))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.FOUR(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(4))
            }
            Calculator.Buttons.FIVE(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(5))
            }
            Calculator.Buttons.SIX(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(6))
            }
            Calculator.Buttons.SUBTRACT(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Operation(Operation.Subtract))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.ONE(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(1))
            }
            Calculator.Buttons.TWO(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(2))
            }
            Calculator.Buttons.THREE(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Number(3))
            }
            Calculator.Buttons.ADD(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Operation(Operation.Add))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Calculator.Buttons.ZERO(
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f)
            ) {
                calculatorManager.onAction(Action.Number(0))
            }
            Calculator.Buttons.DECIMAL(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Decimal)
            }
            Calculator.Buttons.EQUAL(modifier = defaultModifier) {
                calculatorManager.onAction(Action.Calculate)
            }
        }
    }
}