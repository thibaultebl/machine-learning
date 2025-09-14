import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        DatasetLoader loader = new DatasetLoader("src/main/resources/delaney_solubility_with_descriptors.csv");
        double[][] data = loader.loadDataset();
        DataSplit spit = new DataSplit();
        double[][] data2 = spit.getTrainingData(data);
        Operations test = new Operations(data2);
        System.out.println(Arrays.toString(test.meanOperation()));
    }
}
