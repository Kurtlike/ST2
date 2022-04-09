package Math_unit.Base;

import st.Math.Base.Ln;
import st.csv.CsvWriter;
import st.csv.Dot;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    @Test
    void invoke() {
        Ln ln = new Ln(0.001);
        assertTrue(isInRange(Double.NaN,0, ln.invoke(-2)));
        assertTrue(isInRange(Double.NaN,0, ln.invoke(0)));
        assertTrue(isInRange(0,0.001, ln.invoke(1)));
        assertTrue(isInRange(1,0.001, ln.invoke(Math.E)));
    }
    @Test
    void csvWrite(){
        Ln ln = new Ln(0.001);
        ArrayList<Dot> dots = new ArrayList<>();
        double bottomBound = -2;
        double upperBound = 10;
        double step = 0.2;
        while (bottomBound < upperBound){
            Dot dot = new Dot();
            dot.x = bottomBound;
            dot.y = ln.invoke(dot.x);
            dots.add(dot);
            bottomBound+= step;
        }
        CsvWriter.write("csv_output/результаты_модуля_ln.csv",dots);
    }
    boolean isInRange(double expected, double accuracy, double actual){
        if(Double.isNaN(expected) && Double.isNaN(actual)) return true;
        return (actual >= expected - accuracy) && (actual <= expected + accuracy);
    }
}