package Math_unit.Base;

import st.Math.Base.Sin;
import st.csv.CsvWriter;
import st.csv.Dot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SinTest {

    @Test
    void invoke() {
        Sin sin = new Sin(0.001);
        assertTrue(isInRange(1,0.01, sin.invoke(Math.PI/2)));
        assertTrue(isInRange(0,0.01, sin.invoke(0)));
        assertTrue(isInRange(0.5,0.01, sin.invoke(Math.PI/6)));
    }
    @Test
    void csvWrite(){
        Sin sin = new Sin(0.001);
        ArrayList<Dot> dots = new ArrayList<>();
        double bottomBound = -5;
        double upperBound = 5;
        double step = 0.2;
        while (bottomBound < upperBound){
            Dot dot = new Dot();
            dot.x = bottomBound;
            dot.y = sin.invoke(dot.x);
            dots.add(dot);
            bottomBound+= step;
        }
        CsvWriter.write("csv_output/результаты_модуля_sin.csv",dots);
    }
    boolean isInRange(double expected, double accuracy, double actual){
        if(Double.isNaN(expected) && Double.isNaN(actual)) return true;
        return (actual >= expected - accuracy) && (actual <= expected + accuracy);
    }
}