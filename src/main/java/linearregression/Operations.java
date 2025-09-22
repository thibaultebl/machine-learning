package linearregression;

import org.apache.commons.math3.linear.*;

public class Operations{
    public double[][] trainingSet;

    public Operations(double[][] trainingSet){
        this.trainingSet = trainingSet;
    }
    public double[][] separationX(){
        double[][] X = new double[trainingSet.length][trainingSet[0].length];
        for(int i = 0; i < X.length; i++){
            X[i][0] = 1.0;
            for(int j = 1; j < X[i].length; j++){
                X[i][j] = trainingSet[i][j-1];
            }
        }
        return X;
    }
    public double[] separationY(){
        double[] Y = new double[trainingSet.length];
        for(int i = 0; i < Y.length; i++){
            Y[i] = trainingSet[i][trainingSet[i].length-1];
        }
        return Y;
    }

    public double[] betaOperation() {
        double[][] Xdata = separationX();
        double[] ydata = separationY();
        RealMatrix X = new Array2DRowRealMatrix(Xdata);
        RealVector Y = new ArrayRealVector(ydata);
        RealMatrix XtX = X.transpose().multiply(X);
        DecompositionSolver solver;

        try{
            solver = new LUDecomposition(XtX).getSolver();
        } catch (SingularMatrixException e){
            throw new RuntimeException("matrix is singular",e);
        }

        RealVector beta = solver.solve(X.transpose().operate(Y));
        return beta.toArray();

        /*Here is a more robust version regarding chatgpt, but the solving is more abstract and happen internally
        *public double[] betaOperation() {
        RealMatrix X = buildXMatrix();
        RealVector Y = buildYVector();

        // Use SVD for stability
        DecompositionSolver solver = new SingularValueDecomposition(X).getSolver();
        RealVector beta = solver.solve(Y);

        return beta.toArray();
    }
        *
        *
        * */
    }


}