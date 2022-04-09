package st.Math.Base;

public class Ln extends BaseMath {
    public Ln(double accuracy) {
        super(accuracy);
    }

    @Override
    public double invoke(double x) {
        if(x <= 0) return Double.NaN;
        if(x == 1) return 0;
        double previousValue = 0;
        double currentValue = 0;
        int n = 1;
        if(x < 2){
            x-= 1;
            do{
                previousValue = currentValue;
                currentValue+= (Math.pow(-1, n + 1) * Math.pow(x, n))/n;
                n++;
            }while (Math.abs(currentValue - previousValue) > accuracy && n < 18);
            return currentValue;
        }else {
            x = x/(x-1);
            do{
                previousValue = currentValue;
                currentValue+= 1/(n * Math.pow(x, n));
                n++;
            }while (Math.abs(currentValue - previousValue) > accuracy && n < 18);
            return currentValue;
        }
    }
}
