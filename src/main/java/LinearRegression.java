public class LinearRegression {
    public Operations operations;
    public double m;
    public double b;
    public LinearRegression(double[][] training) {
        this.operations = new Operations(training);
        this.m = operations.mOperations();
        this.b = operations.bOperations();

    }
    public double getLinearRegression(double x) {
        return (m * x) + b;
    }
}
