package neuralnetwork;

public class Neuron {
    public float[] weights;
    public float bias;
    private float value;
    private StatUtil util;
    public float[] lastInputs;

    public Neuron(int inputSize) {
        util = new StatUtil();
        weights = new float[inputSize];
        for (int i = 0; i < inputSize; i++) {
            weights[i] = util.randomWeight(inputSize);
        }
        bias = util.randomWeight(inputSize);
    }

    public float activate(float sum) {
        return util.tanh(sum);
    }
    public float derivative(float x) {
        return util.tanhDerivative(x);
    }
    public float getValue() {
        return this.value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
