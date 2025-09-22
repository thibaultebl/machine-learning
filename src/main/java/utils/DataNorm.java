package utils;

public class DataNorm {
    private double outputMean;
    private double outputStd;
    private int outputColIndex;
    private double[][] dataset;
    private double[][] normalizedDataset;

    public DataNorm(double[][] dataset, int outputCol) {
        this.dataset = dataset;
        this.outputColIndex = outputCol;
    }
    public double[][] normalize2D() {
        int rows = dataset.length;
        int cols = dataset[0].length;
        double[][] normalized = new double[rows][cols];

        for (int j = 0; j < cols; j++) {
            double sum = 0.0;
            double mean = 0.0;
            double std = 0.0;
            for (int i = 0; i < rows; i++) sum += dataset[i][j];
            mean = sum / rows;

            double sqSum = 0.0;
            for (int i = 0; i < rows; i++) sqSum += Math.pow(dataset[i][j] - mean, 2);
            std = Math.sqrt(sqSum / rows);

            if (j == outputColIndex) {
                outputMean = mean;
                outputStd = std;
            }

            for (int i = 0; i < rows; i++) {
                normalized[i][j] = (dataset[i][j] - mean) / std;
            }
        }
        normalizedDataset = normalized;
        return normalized;
    }
    public double[] getData(int index) {
        double[] row = normalizedDataset[index];
        double[] result = new double[row.length-1];
        for (int i = 0; i < result.length; i++) {
            result[i] = row[i];
        }
        return result;
    }

    public double denormalizeOutput(double normalizedValue) {
        return normalizedValue * outputStd + outputMean;
    }

}
