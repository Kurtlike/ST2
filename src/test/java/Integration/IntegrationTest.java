package Integration;
import st.MainFunction;
import st.Math.*;
import st.Math.Base.Ln;
import st.Math.Base.Sin;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    Sin sin = Mockito.mock(Sin.class);
    Ln ln = Mockito.mock(Ln.class);
    DerivativeFunctions functions = Mockito.mock(DerivativeFunctions.class);
    MainFunction mainFunction;
    @Test
    void ctgFromSin(){
        functions = new DerivativeFunctions(sin, 0.01);
        Mockito.when(sin.invoke(0)).thenReturn(Double.NaN);
        assertEquals(Double.NaN,functions.ctg(0));
        Mockito.when(sin.invoke(Math.PI/2)).thenReturn(1.0);
        assertEquals(0, functions.ctg(Math.PI/2));
    }
    @Test
    void logFromLn(){
        functions = new DerivativeFunctions(ln, 0.01);
        Mockito.when(ln.invoke(0)).thenReturn(Double.NaN);
        Mockito.when(ln.invoke(2)).thenReturn(0.69314718056);
        assertEquals(Double.NaN, functions.log(2,0));

        Mockito.when(ln.invoke(-1)).thenReturn(Double.NaN);
        Mockito.when(ln.invoke(2)).thenReturn(0.69314718056);
        assertEquals(Double.NaN, functions.log(2,-1));

        Mockito.when(ln.invoke(1)).thenReturn(0.0);
        Mockito.when(ln.invoke(3)).thenReturn(1.09861228867);
        assertEquals(Double.NaN, functions.log(1,3));

        Mockito.when(ln.invoke(Math.pow(Math.E,2))).thenReturn(2.0);
        Mockito.when(ln.invoke(Math.pow(Math.E,8))).thenReturn(8.0);
        assertEquals(4.0, functions.log(Math.pow(Math.E,2),Math.pow(Math.E,8)));
    }
    @Test
    void mainFunkInvoke(){
        Mockito.when(functions.ctg(1.0)).thenReturn(0.0);
        Mockito.when(functions.log(5, 1)).thenReturn(0.0);
        Mockito.when(functions.log(3, 1)).thenReturn(0.0);
        Mockito.when(functions.ln( 1)).thenReturn(0.0);
        mainFunction = new MainFunction(functions);
        assertEquals(Double.NaN,mainFunction.invoke(1));

        Mockito.when(functions.ctg(-Math.PI/2)).thenReturn(0.0);
        mainFunction = new MainFunction(functions);
        assertEquals(0,mainFunction.invoke(-Math.PI/2));
    }
}
