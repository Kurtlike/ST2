package Math_unit;

import org.junit.jupiter.api.Test;
import st.MainFunction;
import st.Math.DerivativeFunctions;

import static org.junit.jupiter.api.Assertions.*;

class MainFunctionTest {

    @Test
    void invoke() {
        MainFunction mainFunction = new MainFunction(0.001);
        assertEquals(Double.NaN, mainFunction.invoke(1));
        assertEquals(0, -mainFunction.invoke(-Math.PI/2));
    }
}