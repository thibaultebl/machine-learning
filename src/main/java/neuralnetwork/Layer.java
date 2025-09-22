package neuralnetwork;

public class Layer {

    private Neuron[] neuronsLayer;
    private int inputSize;


    public Layer(int inputSize, int numberOfNeurons) {
        this.inputSize = inputSize;
        neuronsLayer = new Neuron[numberOfNeurons];
        for(int i = 0; i < numberOfNeurons; i++) {
            neuronsLayer[i] = new Neuron(inputSize);
        }
    }

    public double[] forward(double[] inputs) {
        double[] outputs = new double[neuronsLayer.length];


        for (int i = 0; i < neuronsLayer.length; i++) {
            Neuron neuron = neuronsLayer[i];

            double sum = 0;
            for (int j = 0; j < inputs.length; j++) {
                sum += inputs[j] * neuron.weights[j];
            }
            sum += neuron.bias;
            neuron.lastInputs = inputs.clone();

            double activated = neuron.activate(sum); //erase the linearity
            neuron.setValue(activated);
            outputs[i] = activated;
        }
        return outputs;
    }
    public double[] backward(double[] errors, double learningRate) { // not understood completely
        double[] prevErrors = new double[neuronsLayer[0].weights.length];

        for (int i = 0; i < neuronsLayer.length; i++) {
            Neuron neuron = neuronsLayer[i];
            double delta = errors[i] * neuron.derivative(neuron.getValue());
            for(int j = 0; j < neuron.weights.length; j++) {
                prevErrors[j] += delta * neuron.weights[j];
                neuron.weights[j] -= learningRate * delta * neuron.lastInputs[j];
            }
            neuron.bias -= learningRate * delta;
        }
        return prevErrors;
    }
    public Neuron[] getNeurons() { return neuronsLayer; }
}
