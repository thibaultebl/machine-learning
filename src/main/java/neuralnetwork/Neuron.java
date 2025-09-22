package neuralnetwork;

public class Neuron {
    public double[] weights;
    public double bias;
    private double value;
    private StatUtil util;
    public double[] lastInputs;

    public Neuron(int inputSize) {
        util = new StatUtil();
        weights = new double[inputSize];
        for (int i = 0; i < inputSize; i++) {
            weights[i] = util.randomWeight();
        }
        bias = util.randomWeight();
    }
    public double activate(double sum) {
        return util.tanh(sum);
    }
    public double derivative(double x) {
        return util.tanhDerivative(x);
    }
    public double getValue() {
        return this.value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
