package st;

import st.Math.*;
public class MainFunction {
    private DerivativeFunctions math;
    public MainFunction(double accuracy) {
        math = new DerivativeFunctions(accuracy);
    }
    public MainFunction(DerivativeFunctions derivativeFunctions) {
        math = derivativeFunctions;
    }
    public double invoke(double x){
        if(x <= 0){
            return math.ctg(x);
        }
        else{
            double up = Math.pow(math.log(5, x) + math.log(5, x),2) * (math.log(3, x) + math.ln(x));
            double bot = (math.log(3, x) * math.log(5, x * x));
            return Math.pow(up / bot , 2);
        }
    }
}
