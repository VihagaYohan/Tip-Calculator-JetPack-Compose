package com.example.tipcalculator
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Test
import org.junit.Rule
import java.text.NumberFormat

// instrumentation UI test
class TipUITest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalLayout()
            }
        }
        // accessing UI components through nodes
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10") // adding value to text field

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found"
        )
    }
}