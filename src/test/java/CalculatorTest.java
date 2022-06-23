import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void add() throws Exception {
        //when
        assertEquals(0,calculator.Add(""));
        assertEquals(1,calculator.Add("1"));
        assertEquals(3,calculator.Add("1,2"));
        assertEquals(10,calculator.Add("1,3,2,3,1"));
        assertEquals(6,calculator.Add("1\n2,3"));
        assertEquals(3,calculator.Add("//;\n1;2"));

        Throwable exception = assertThrows(Exception.class , ()-> calculator.Add("-1,-2,3"));
        assertEquals("negatives not allowed: [-1, -2]",exception.getMessage());
    }
}