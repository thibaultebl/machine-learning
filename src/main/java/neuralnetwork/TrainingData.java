package neuralnetwork;

public class TrainingData {

    private float[] inputs;
    private float[] expectedOutput;


    public TrainingData(float[] inputs, float[] expectedOutput) {
        this.inputs = inputs;
        this.expectedOutput = expectedOutput;
    }

    // --- Getters ---
    public float[] getInputs() {
        return this.inputs;
    }
    public float[] getExpectedOutput() {
        return this.expectedOutput;
    }
}