package com.example.tipCalculator
import com.example.tipcalculator.calculateTip
import org.junit.Test
import org.junit.Assert.assertEquals
import java.text.NumberFormat

// local test
class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        // constant variables
        val amount = 10.0
        val tipPercent = 20.0
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}