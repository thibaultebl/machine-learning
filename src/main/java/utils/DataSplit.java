package utils;

public class DataSplit {
    public double[][] dataTraining;
    public double[][] dataTest;


    public double[][] getTrainingData(double[][] data) {
        int eighty = (int)(data.length * 0.8);
        dataTraining = new double[eighty][data[0].length];
        System.arraycopy(data, 0, dataTraining, 0, eighty);
        return dataTraining;
    }
    public double[][] getTestData(double[][] data) {
        int eighty = (int)(data.length * 0.8);
        int twenty = data.length - eighty;
        dataTest = new double[twenty][data[0].length];
        System.arraycopy(data, eighty, dataTest, 0, twenty);
        return dataTest;
    }
}
