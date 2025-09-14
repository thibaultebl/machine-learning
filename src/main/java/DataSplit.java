public class DataSplit {
    public double[][] dataTraining;
    public double[][] dataTest;


    public double[][] getTrainingData(double[][] data) {

        int eighty = (int)(data.length * 0.8);
        dataTraining = new double[eighty][data[0].length];
        for(int j = 0; j < eighty; j++) {
                dataTraining[j] = data[j];
        }
        return dataTraining;
    }
}
