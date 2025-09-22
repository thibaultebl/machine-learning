package linearregression;

public class LinearRegression {
    public Operations operations;
    public double[] beta;

    public LinearRegression(double[][] training) {
        this.operations = new Operations(training);
        this.beta = operations.betaOperation();
    }
    public double getLinearRegression(double[] x) {
        double y = beta[0];
        for(int i = 0; i < x.length; i++) {
            y += beta[i+1] * x[i];
        }
        return y;
    }
}
