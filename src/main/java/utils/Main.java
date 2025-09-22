package utils;


import neuralnetwork.NeuralNetwork;
import neuralnetwork.TrainingData;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        // convert csv into array 2D, (without the first index columns)
        DatasetLoader loader = new DatasetLoader("src/main/resources/delaney_solubility_with_descriptors.csv");
        double[][] dataset = loader.loadDataset();

        // object instance
        DataSplit split = new DataSplit();
        DataNorm norm = new DataNorm(dataset, 4);
        double[][] datasetNorm = norm.normalize2D();

        //split dataset
        double[][] training = split.getTrainingData(datasetNorm);
        double[][] test = split.getTestData(datasetNorm);

        //LinearRegression lr = new LinearRegression(training);
        //double[] x = {2.5954000000000006, 167.85, 0.0, 0.0};
        //System.out.println(lr.getLinearRegression(x));

        // convert the data set into input part and output part, the NN handle it easier
        TrainingData[] trainData = TrainingData.fromMatrix(training);

        // define size layer of neurons, 4 input, 5 hidden neurons and one output.
        int[] layerSizes = {4, 5, 1};

        //function step
        double learningRate = 0.01;

        //initialisation NN
        NeuralNetwork nn = new NeuralNetwork(layerSizes, learningRate);

        // train on data
        nn.train(trainData, 1000);

        // predict
        double[] in = norm.getData(0);
        double prediction = nn.predict(in)[0]; // index 0 since only one output neuron goes out, it is flexible for the future if many output predictions are wished.
        System.out.println(norm.denormalizeOutput(prediction));




        }




    }

