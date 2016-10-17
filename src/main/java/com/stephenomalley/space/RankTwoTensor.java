package com.stephenomalley.space;

/**
 * Created by kida_ on 17/10/2016.
 */
public class RankTwoTensor {

    protected double[][] tensorMatrix;

    public RankTwoTensor(){
        this.tensorMatrix = new double[2][2];
    }

    public RankTwoTensor(int N){
        this.tensorMatrix = new double[N][N];
    }

    public RankTwoTensor(double[][] tensorMatrix){
        this.tensorMatrix = tensorMatrix;
    }

    public double[][] getTensorMatrix() {
        return tensorMatrix;
    }

    public void setTensorMatrix(double[][] tensorMatrix) {
        this.tensorMatrix = tensorMatrix;
    }

    public RankTwoTensor add(RankTwoTensor tensor){
        double[][] addition = new double[this.tensorMatrix.length][this.tensorMatrix[0].length];
        for (int i =0; i < this.tensorMatrix.length; i++){
            for (int j=0; j < this.tensorMatrix[i].length; j++ ){
                addition[i][j] = this.tensorMatrix[i][j] + tensor.tensorMatrix[i][j];
            }
        }
        return new RankTwoTensor(addition);
    }

    public RankTwoTensor scalarMultiply(double scalar){
        double[][] addition = new double[this.tensorMatrix.length][this.tensorMatrix[0].length];
        for (int i =0; i < this.tensorMatrix.length; i++){
            for (int j=0; j < this.tensorMatrix[i].length; j++ ){
                addition[i][j] = this.tensorMatrix[i][j]*scalar;
            }
        }
        return new RankTwoTensor(addition);
    }
}
