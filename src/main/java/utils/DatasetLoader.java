package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatasetLoader {
    public String filepath;

    public DatasetLoader(String filepath) {
        this.filepath = filepath;
    }
    public double[][] loadDataset() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        ArrayList<double[]> rows = new ArrayList<>();
        String line;
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }
            rows.add(row);
        }
        br.close();

        double[][] result = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            result[i] = rows.get(i);
        }
        return result;

    }
}