package st;

import st.Math.*;

public class Main {
    public static void main(String[] args) {
        DerivativeFunctions functions = new DerivativeFunctions(0.000001);
        MainFunction mainFunction = new MainFunction(0.001);
        System.out.println(functions.ctg(Math.PI/2));
    }
}
