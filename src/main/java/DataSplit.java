public class DataSplit {
    public double[][] dataTraining;
    public double[][] dataTest;


    public double[][] getTrainingData(double[][] data) {
        dataTraining = new double[data.length][data[0].length];
        int count = 0;
        for(int i = 0; i < data.length; i++) {
            count+=1;
        }
        int eighty = (count/100) * 80;

        for(int j = 0; j < eighty; j++) {
            for(int k = 0; k < data[j].length; k++) {
                dataTraining[j][k] = data[j][k];
            }
        }
        return dataTraining;
    }
}
