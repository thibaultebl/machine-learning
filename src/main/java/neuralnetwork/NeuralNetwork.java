package neuralnetwork;

public class NeuralNetwork {

    private Layer[] layers;
    private double learningRate;
    StatUtil util;


    public NeuralNetwork(int[] layerSizes, double learningRate) {
        util = new StatUtil();
        layers = new Layer[layerSizes.length-1];
        for (int i = 0; i < layers.length; i++) {
            layers[i] = new Layer(layerSizes[i], layerSizes[i+1]);
        }
        this.learningRate = learningRate;
    }

    public double[] forward(double[] inputs) {
        double[] outputs = inputs;

        for(Layer layer : layers) {
            outputs = layer.forward(outputs);
        }
        return outputs;
    }
    public void backward(double[] expectedOutput) {
        Layer outputLayer = layers[layers.length - 1];
        double[] errors = new double[outputLayer.getNeurons().length];

        for(int i = 0; i < outputLayer.getNeurons().length; i++) {
            Neuron neuron = outputLayer.getNeurons()[i];
            errors[i] = util.mseDerivative(neuron.getValue(), expectedOutput[i]);
        }

        for(int l = layers.length - 1; l >= 0; l--) {
            errors = layers[l].backward(errors, learningRate);
        }
    }
    public void train(TrainingData[] dataset, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for(TrainingData sample : dataset) {

                double[] predicted = forward(sample.getInputs());

                backward(sample.getExpectedOutput());
            }
            if (epoch % 100 == 0) {
                double totalLoss = 0;
                for (TrainingData sample : dataset) {
                    double[] pred = forward(sample.getInputs());
                    totalLoss += util.mse(pred, sample.getExpectedOutput());
                }
                System.out.println("Epoch " + epoch + " Loss: " + totalLoss / dataset.length);
            }
        }
    }
    public double[] predict(double[] inputs) {
        double[] outputs = inputs;
        for(Layer layer : layers) {
            outputs = layer.forward(outputs);
        }
        return outputs;
    }
}
