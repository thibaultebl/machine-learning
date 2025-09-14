import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DatasetLoader loader = new DatasetLoader("src/main/resources/delaney_solubility_with_descriptors.csv");
        double[][] dataset = loader.loadDataset();

        DataSplit split = new DataSplit();
        double[][] training = split.getTrainingData(dataset);
        double[][] test = split.getTestData(dataset);

        LinearRegression lr = new LinearRegression(training);
        System.out.println(lr.getLinearRegression(0.4051));


    }
}
