import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void add() {
        //when
        assertEquals(0,calculator.Add(""));
        assertEquals(1,calculator.Add("1"));
        assertEquals(3,calculator.Add("1,2"));
    }
}