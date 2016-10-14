package com.stephenomalley.blobs;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;

/**
 * Created by kida_ on 14/10/2016.
 */
public class Phi2D implements UnivariateDifferentiableFunction {

    private double epsilon;

    public Phi2D() {
    }

    public Phi2D(double epsilon) {
        this.epsilon = epsilon;
    }

    public DerivativeStructure value(DerivativeStructure t) throws DimensionMismatchException {
        return null;
    }

    public double value(double x) {
        return (3 * Math.pow(epsilon, 3)) / (2 * Math.PI * Math.pow(Math.pow(x, 2) + Math.pow(epsilon, 2), (double) 5 / 2));
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }
}
