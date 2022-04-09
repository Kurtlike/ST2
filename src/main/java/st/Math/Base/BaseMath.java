package st.Math.Base;

public abstract class BaseMath {
    public BaseMath(double accuracy) {
        this.accuracy = accuracy;

    }
    protected double accuracy;
    public abstract double invoke(double x);
    protected int getFactorial(int number){
        int sum = 1;
        for(int i = 2; i <= number; i++){
            sum*= i;
        }
        return sum;
    }
}
