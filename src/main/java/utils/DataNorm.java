package utils;

public class DataNorm {
    private double outputMean;
    private double outputStd;
    private int outputColIndex;

    public double[][] normalize(double[][] data, int outputCol) {
        int rows = data.length;
        int cols = data[0].length;
        double[][] normalized = new double[rows][cols];
        outputColIndex = outputCol;

        for (int j = 0; j < cols; j++) {
            double sum = 0.0;
            for (int i = 0; i < rows; i++) sum += data[i][j];
            double mean = sum / rows;

            double sqSum = 0.0;
            for (int i = 0; i < rows; i++) sqSum += Math.pow(data[i][j] - mean, 2);
            double std = Math.sqrt(sqSum / rows);

            if (j == outputCol) {
                outputMean = mean;
                outputStd = std;
            }

            for (int i = 0; i < rows; i++) {
                normalized[i][j] = (data[i][j] - mean) / std;
            }
        }
        return normalized;
    }
    public double denormalizeOutput(double normalizedValue) {
        return normalizedValue * outputStd + outputMean;
    }
}
