package Math_unit;

import st.Math.*;
import st.csv.CsvWriter;
import st.csv.Dot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DerivativeFunctionsTest {

    @Test
    void ctg() {
        DerivativeFunctions f = new DerivativeFunctions(0.001);
        assertTrue(isInRange(Double.NaN,0, f.ctg(Math.PI)));
        assertTrue(isInRange(Double.NaN,0, f.ctg(0)));
        assertTrue(isInRange(1,0.001, f.ctg(Math.PI/4)));
        assertTrue(isInRange(0,0.1, f.ctg(Math.PI/2)));
    }
    @Test
    void csvCtgWrite(){
        DerivativeFunctions f = new DerivativeFunctions(0.001);
        ArrayList<Dot> dots = new ArrayList<>();
        double bottomBound = -5;
        double upperBound = 5;
        double step = 0.01;
        while (bottomBound < upperBound){
            Dot dot = new Dot();
            dot.x = bottomBound;
            dot.y = f.ctg(dot.x);
            dots.add(dot);
            bottomBound+= step;
        }
        CsvWriter.write("csv_output/результаты_модуля_ctg.csv",dots);
    }
    @Test
    void log() {
        DerivativeFunctions f = new DerivativeFunctions(0.001);
        assertTrue(isInRange(Double.NaN,0, f.log(12,-1)));
        assertTrue(isInRange(1,0, f.log(2,2)));
        assertTrue(isInRange(0,0, f.log(5,1)));
        assertTrue(isInRange(3,0.1, f.log(2,8)));
    }
    @Test
    void csvLogWrite(){
        DerivativeFunctions f = new DerivativeFunctions(0.001);
        ArrayList<Dot> dots = new ArrayList<>();
        double bottomBound = -2;
        double upperBound = 10;
        double step = 0.2;
        while (bottomBound < upperBound){
            Dot dot = new Dot();
            dot.x = bottomBound;
            dot.y = f.log(2,dot.x);
            dots.add(dot);
            bottomBound+= step;
        }
        CsvWriter.write("csv_output/результаты_модуля_log.csv",dots);
    }
    boolean isInRange(double expected, double accuracy, double actual){
        if(Double.isNaN(expected) && Double.isNaN(actual)) return true;
        return (actual >= expected - accuracy) && (actual <= expected + accuracy);
    }
}