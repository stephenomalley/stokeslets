package com.stephenomalley.space;

import com.stephenomalley.exceptions.InvalidSupportMatrixSize;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by kida_ on 18/10/2016.
 */
public class SpaceUtils {

    public static double[] linspace(double min, double max, int spacing){
        double[] interval = new double[spacing];
        for (int i = 0; i < spacing; i++){
            interval[i] = min + i * (max - min) / (spacing - 1);
        }
        return interval;
    }

    public static RealMatrix supportMatrix2D(int N) throws InvalidSupportMatrixSize{

        if (N==0){
            throw new InvalidSupportMatrixSize("Support matrix must be of dimension 2xN where N is greater than zero");
        }

        double[][] idMatrix = new KroenkerDelta().getTensorMatrix();
        double[][] supportMatrix = new double[][]{};

        for (int i=0; i<N; i++){
            supportMatrix = ArrayUtils.addAll(supportMatrix, idMatrix);
        }

        return MatrixUtils.createRealMatrix(supportMatrix).transpose();
    }


}
