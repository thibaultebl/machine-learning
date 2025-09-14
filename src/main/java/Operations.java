public class Operations{
    public double[][] dataset;

    public Operations(double[][] dataset){
        this.dataset = dataset;
    }

    public double[] meanOperation(){
        double[] mean = new double[dataset[0].length];
        double sum = 0;
        for(int i = 0; i < dataset[0].length; i++){
            for(int j = 0; j < dataset.length; j++){
                sum += dataset[j][i];
            }
            mean[i] = sum/dataset.length;
            sum = 0;
        }
        return mean;
    }
    public double[] deviationOperation(){
        double[] deviation = new double[dataset[0].length-1];
        double sdSum = 0;
        double[] mean = meanOperation();

        for(int i = 0; i < dataset[0].length-1; i++){
            for(int j = 0; j < dataset.length; j++){
                sdSum += Math.pow(dataset[j][i] - mean[i], 2);
            }
            deviation[i] = Math.sqrt(sdSum/(dataset.length-1)); // -1 as Bessel's corrections
            sdSum = 0;
        }
        return deviation;
    }
    public double[] covarianceOperation(){
        double[] covariance = new double[dataset[0].length-1];
        double cosum = 0;
        double[] mean = meanOperation();
        for(int i = 0; i < dataset[0].length-1; i++){
            for(int j = 0; j < dataset.length; j++){
                cosum += (dataset[j][i] - mean[i]) * (dataset[j][dataset[0].length-1] - mean[dataset[0].length-1]);
            }
            covariance[i] = cosum/(dataset.length-1);
            cosum = 0;
        }
        return covariance;
    }

    public double[] mOperations(){
        double[] mOperation = new double[dataset[0].length-1];
        double[] covariance = covarianceOperation();
        double[] sd = deviationOperation();
        for(int i = 0; i < dataset[0].length-1; i++){
                mOperation[i] = covariance[i]/(sd[i]*sd[i]);
        }
        return mOperation;
    }







}