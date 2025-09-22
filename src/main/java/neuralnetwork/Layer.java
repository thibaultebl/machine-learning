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

    public float[] forward(float[] inputs) {
        float[] outputs = new float[neuronsLayer.length];


        for (int i = 0; i < neuronsLayer.length; i++) {
            Neuron neuron = neuronsLayer[i];

            float sum = 0;
            for (int j = 0; j < inputs.length; j++) {
                sum += inputs[j] * neuron.weights[j];
            }
            sum += neuron.bias;
            neuron.lastInputs = inputs.clone();

            float activated = neuron.activate(sum); //erase the linearity
            neuron.setValue(activated);
            outputs[i] = activated;
        }
        return outputs;
    }
    public float[] backward(float[] errors, float learningRate) { // not understood completely
        float[] prevErrors = new float[neuronsLayer[0].weights.length];

        for (int i = 0; i < neuronsLayer.length; i++) {
            Neuron neuron = neuronsLayer[i];
            float delta = errors[i] * neuron.derivative(neuron.getValue());
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
