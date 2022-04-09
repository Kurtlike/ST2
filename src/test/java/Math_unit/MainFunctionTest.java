package Math_unit;

import org.junit.jupiter.api.Test;
import st.MainFunction;
import st.Math.DerivativeFunctions;
import st.csv.CsvWriter;
import st.csv.Dot;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainFunctionTest {

    @Test
    void invoke() {
        MainFunction mainFunction = new MainFunction(0.001);
        assertEquals(Double.NaN, mainFunction.invoke(1));
        assertEquals(0, -mainFunction.invoke(-Math.PI/2));
    }
    @Test
    void csvLogWrite(){
        MainFunction mainFunction = new MainFunction(0.001);
        ArrayList<Dot> dots = new ArrayList<>();
        double bottomBound = -10;
        double upperBound = 10;
        double step = 0.01;
        while (bottomBound < upperBound){
            Dot dot = new Dot();
            dot.x = bottomBound;
            dot.y = mainFunction.invoke(dot.x);
            dots.add(dot);
            bottomBound+= step;
        }
        CsvWriter.write("csv_output/результаты_модуля_mainFunc.csv",dots);
    }
}