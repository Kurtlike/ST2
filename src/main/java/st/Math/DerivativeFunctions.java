package st.Math;

import st.Math.Base.BaseMath;
import st.Math.Base.Ln;
import st.Math.Base.Sin;

public class DerivativeFunctions {
    private BaseMath ln;
    private BaseMath sin;

    public DerivativeFunctions(double accuracy) {
        ln = new Ln(accuracy);
        sin = new Sin(accuracy);
    }
    public DerivativeFunctions(Sin sin, Ln ln) {
       this.ln = ln;
       this.sin = sin;
    }
    public DerivativeFunctions(Sin sin,double accuracy) {
        ln = new Ln(accuracy);
        this.sin = sin;
    }
    public DerivativeFunctions(Ln ln, double accuracy) {
        this.ln = ln;
        sin = new Sin(accuracy);
    }
    public double sin(double x){
        return sin.invoke(x);
    }
    public double ln(double x){
        return ln.invoke(x);
    }
    public double ctg(double x){
        if(x % Math.PI == 0) return Double.NaN;
        double sinX = sin.invoke(x);
        double cosX = sin.invoke(x + Math.PI/2);
        return cosX / sinX;
    }
    public double log(double base, double value){
        if (base == 1 || base <= 0 || value < 0) return Double.NaN;
        if(value == 1) return 0;
        return ln.invoke(value)/ln.invoke(base);
    }
}
