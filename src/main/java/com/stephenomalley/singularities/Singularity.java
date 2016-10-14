package com.stephenomalley.singularities;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

/**
 * Created by kida_ on 14/10/2016.
 */
public abstract class Singularity {

    public void calculateGreensFunction() {
        int params = 1;
        int order = 3;
        double xRealValue = 2.5;
        DerivativeStructure x = new DerivativeStructure(params, order, 0, xRealValue);
        DerivativeStructure y = x.pow(2);
        System.out.println("y    = " + y.getValue());
        System.out.println("y'   = " + y.getPartialDerivative(1));
        System.out.println("y''  = " + y.getPartialDerivative(2));
        System.out.println("y''' = " + y.getPartialDerivative(3));
    }


}
