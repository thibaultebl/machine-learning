package neuralnetwork;

public class TrainingData {

    private double[] inputs;
    private double[] expectedOutput;

    public TrainingData(double[] inputs, double[] expectedOutput) {
        this.inputs = inputs;
        this.expectedOutput = expectedOutput;
    }
    public double[] getInputs() {
        return this.inputs;
    }
    public double[] getExpectedOutput() {
        return this.expectedOutput;
    }
    public static TrainingData[] fromMatrix(double[][] data) {
        TrainingData[] trainData = new TrainingData[data.length];
        for (int i = 0; i < data.length; i++) {
            double[] inputs = new double[data[i].length - 1]; // all features except last col
            for (int j = 0; j < inputs.length; j++) {
                inputs[j] = data[i][j];
            }
            double[] output = new double[]{data[i][data[i].length - 1]}; // last col = label
            trainData[i] = new TrainingData(inputs, output);
        }
        return trainData;
    }
}