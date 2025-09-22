package utils;


import neuralnetwork.NeuralNetwork;
import neuralnetwork.TrainingData;

import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        DatasetLoader loader = new DatasetLoader("src/main/resources/delaney_solubility_with_descriptors.csv");
        double[][] dataset = loader.loadDataset();

        DataSplit split = new DataSplit();
        DataNorm norm = new DataNorm();
        double[][] training = split.getTrainingData(dataset);
        double[][] test = split.getTestData(dataset);
        double[][] trainNorm = norm.normalize(training, 4);
        double[][] testNorm = norm.normalize(test, 4);
        /*
        LinearRegression lr = new LinearRegression(training);
        double[] x = {2.5954000000000006, 167.85, 0.0, 0.0};
        System.out.println(lr.getLinearRegression(x));*/

        // 3. Initialize NeuralNetwork
        // 4. Train
        // 5. Evaluate
        // 6. Predict
        TrainingData[] trainData = new TrainingData[trainNorm.length];
        for (int i = 0; i < trainNorm.length; i++) {
            float[] inputs = new float[trainNorm[i].length - 1]; // all features except last col
            for (int j = 0; j < inputs.length; j++) {
                inputs[j] = (float) trainNorm[i][j];
            }
            float[] output = new float[]{(float) trainNorm[i][trainNorm[i].length - 1]}; // last col = label
            trainData[i] = new TrainingData(inputs, output);
        }

        int[] layerSizes = {4, 5, 1};
        float learningRate = 0.001f;
        NeuralNetwork nn = new NeuralNetwork(layerSizes, learningRate);

        nn.train(trainData, 1000);

        float[] IN = new float[trainNorm[0].length-1];

        for(int i = 0; i < trainNorm[1].length-1; i++){
            IN[i] = (float) trainNorm[0][i];
        }
        float prediction = nn.predict(IN)[0];

        System.out.println(norm.denormalizeOutput(prediction));




        }




    }

