package neuralnetwork;

import java.util.Random;

public class StatUtil {
    Random rand;

    public StatUtil() {
        rand = new Random();
    }

    public float randomWeight(int nInputs) {
        return (rand.nextFloat() - 0.5f) * 0.2f; // [-0.1, 0.1]
    }
    public float tanh(float x) {
        return (float) Math.tanh(x);
    }
    public float tanhDerivative(float activated) {
        return 1 - activated*activated;
    }
    public float mse(float[] predicted, float[] expected) {
        float sum = 0.0f;
        for (int i = 0; i < predicted.length; i++) {
            float diff = expected[i] - predicted[i];
            sum += diff * diff;
        }
        return sum/predicted.length;
    }
    public float mseDerivative(float predicted, float expected) {
        return 2 * (predicted - expected);
    }
}
