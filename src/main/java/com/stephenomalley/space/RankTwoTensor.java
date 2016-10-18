package com.stephenomalley.space;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;

/**
 * Created by kida_ on 17/10/2016.
 */
public class RankTwoTensor implements Cloneable {

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

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof RankTwoTensor)){
            return false;
        }

        if (obj == this){
            return true;
        }

        RankTwoTensor rankTwoTensor = (RankTwoTensor) obj;

        return Arrays.deepEquals(this.tensorMatrix, rankTwoTensor.getTensorMatrix());
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder().append(this.tensorMatrix).toHashCode();
    }
}
