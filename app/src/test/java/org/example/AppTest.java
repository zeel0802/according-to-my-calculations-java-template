package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();
        
        assertEquals(7, calculator.evaluate("2+5"));
        assertEquals(33, calculator.evaluate("3+6*5"));
        assertEquals(20, calculator.evaluate("4*(2+3)"));
        assertEquals(2, calculator.evaluate("(7+9)/8"));
    }
}
