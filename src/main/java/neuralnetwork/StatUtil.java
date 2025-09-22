package neuralnetwork;

import java.util.Random;

public class StatUtil {
    Random rand;

    public StatUtil() {
        rand = new Random();
    }

    public double randomWeight() {
        return (rand.nextDouble() - 0.5) * 0.2; // [-0.1, 0.1]
    }
    public double tanh(double x) {
        return Math.tanh(x);
    }
    public double tanhDerivative(double activated) {
        return 1 - activated*activated;
    }
    public double mse(double[] predicted, double[] expected) {
        double sum = 0.0;
        for (int i = 0; i < predicted.length; i++) {
            double diff = expected[i] - predicted[i];
            sum += diff * diff;
        }
        return sum/predicted.length;
    }
    public double mseDerivative(double predicted, double expected) {
        return (predicted - expected);
    }
}
