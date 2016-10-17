package com.stephenomalley.blobs;

import com.stephenomalley.space.*;

import java.awt.geom.Point2D;

/**
 * Created by kida_ on 14/10/2016.
 */
public class Phi2D extends Phi {

    private double epsilon;

    public Phi2D() {
    }

    public Phi2D(double epsilon) {
        this.epsilon = epsilon;
    }

    public double value(double x) {
        return (3 * Math.pow(epsilon, 3)) / (2 * Math.PI * Math.pow(Math.pow(x, 2) + Math.pow(epsilon, 2), (double) 5 / 2));
    }

    public double greensFunctionG(double x){
        return (1/(2*Math.PI))*(Math.log(this.epsilon + Math.sqrt(Math.pow(x,2)+Math.pow(this.epsilon, 2)) - (this.epsilon/(Math.sqrt(Math.pow(x,2)+Math.pow(this.epsilon, 2))))));
    }

    public double greensFunctionB(double x){
        return (1/(8*Math.PI))*(Math.pow(x,2)*Math.log(Math.sqrt(Math.pow(x,2)+Math.pow(this.epsilon, 2)) + this.epsilon) - Math.pow(x,2) + this.epsilon*(this.epsilon - Math.sqrt(Math.pow(x,2)+Math.pow(this.epsilon, 2)))+2*this.epsilon*Math.log(Math.sqrt(Math.pow(x,2)+Math.pow(this.epsilon, 2)) + this.epsilon));
    }

    public RankTwoTensor dxdyGreensFunctionB(Point2D.Double x, Point2D.Double x0){
        double r = magnitude(x, x0);
        double R = Math.pow(r,2)+Math.pow(this.epsilon, 2);
        double rRoute = Math.sqrt(R);
        double r2E = Math.pow(r,2)+2*Math.pow(this.epsilon, 2);
        double rRouteE = R + this.epsilon;
        double rPower = (double) Math.pow(R, 3/2);
        RankTwoTensor xixj = new RankTwoTensor(new double[][]{{x.getX()*x0.getX(),x.getX()*x0.getY()},{x.getY()*x0.getX(), x.getY()*x0.getY()}});
        KroenkerDelta delta = new KroenkerDelta();
        RankTwoTensor first = delta.scalarMultiply(2*Math.log( rRoute + this.epsilon));
        RankTwoTensor second = delta.scalarMultiply(-2);
        RankTwoTensor third = delta.scalarMultiply(-this.epsilon/(rRoute));
        RankTwoTensor fourth_a = xixj.scalarMultiply(4);
        RankTwoTensor fourth_b = delta.scalarMultiply(r2E);
        RankTwoTensor fourth = fourth_b.add(fourth_a).scalarMultiply(1/(rRouteE*rRoute));
        RankTwoTensor fifth = xixj.scalarMultiply(-r2E/(rRouteE*R));
        RankTwoTensor sixth = xixj.scalarMultiply(-r2E/(rRouteE*rPower));
        RankTwoTensor seventh = xixj.scalarMultiply(-this.epsilon/rPower);

        return first.add(second).add(third).add(fourth).add(fifth).add(sixth).add(seventh);
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double magnitude(Point2D.Double x, Point2D.Double x0) {
        return Math.sqrt(
                Math.pow(x.getX() - x0.getX(), 2) + Math.pow(x.getY() - x0.getY(), 2)
        );
    }
}
