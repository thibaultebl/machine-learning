public class Operations{
    public double[][] trainingSet;

    public Operations(double[][] trainingSet){
        this.trainingSet = trainingSet;
    }

    public double meanOperation4x(){
        double mean = 0;
        double sum = 0;
        for(int i = 0; i < trainingSet.length; i++){
                sum += trainingSet[i][0];
        }
        mean = sum/trainingSet.length;
        return mean;
    }
    public double meanOperation4y(){
        double mean = 0;
        double sum = 0;
        for(int i = 0; i < trainingSet.length; i++){
            sum += trainingSet[i][4];
        }
        mean = sum/trainingSet.length;
        return mean;
    }
    public double deviationOperation(){
        double deviation = 0;
        double sdSum = 0;
        double mean = meanOperation4x();
        for(int i = 0; i < trainingSet.length; i++){
                sdSum += Math.pow(trainingSet[i][0] - mean, 2);
        }
        deviation = Math.sqrt(sdSum/(trainingSet.length-1)); // Bessel's correction
        return deviation;
    }
    public double covarianceOperation(){
        double covariance = 0;
        double cosum = 0;
        double meanX = meanOperation4x();
        double meanY = meanOperation4y();
        for(int i = 0; i < trainingSet.length; i++){
                cosum += (trainingSet[i][0] - meanX) * (trainingSet[i][4] - meanY);
        }
        covariance = cosum/(trainingSet.length-1); // Bessel's correciton
        return covariance;
    }

    public double mOperations(){
        double mOperation = 0;
        double covariance = covarianceOperation();
        double sd = deviationOperation();
        mOperation = covariance/(sd*sd);
        return mOperation;
    }
    public double bOperations(){
        double meanx = meanOperation4x();
        double meany = meanOperation4y();
        double m = mOperations();
        double b = 0;
        double sum = 0;
        b = meany - (m*meanx);
        return b;
    }







}