package com.stephenomalley.space;

/**
 * Created by kida_ on 17/10/2016.
 */
public final class KroenkerDelta extends RankTwoTensor{

    public KroenkerDelta(){
        for (int i = 0; i < this.tensorMatrix.length; i++){
            this.tensorMatrix[i][i] = 1.0;
        }
    }

}
