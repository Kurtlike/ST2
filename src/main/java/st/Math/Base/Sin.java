package st.Math.Base;

public class Sin extends BaseMath {
    public Sin(double accuracy) {
        super(accuracy);
    }

    @Override
    public double invoke(double x) {
        while(x > Math.PI){
            x-=2 * Math.PI;
        }
        while(x < -Math.PI){
            x+=2 * Math.PI;
        }
        double previousValue;
        double currentValue = x;
        int n = 1;
        do{
            previousValue = currentValue;
            currentValue+= (Math.pow(-1, n) * Math.pow(x, 2 * n + 1))/getFactorial(2 * n +1);
            n++;
        }while (Math.abs(currentValue - previousValue) > accuracy && n < 7);
        if(currentValue > 1) return 1;
        if(currentValue < -1) return -1;
        return currentValue;
    }
}
