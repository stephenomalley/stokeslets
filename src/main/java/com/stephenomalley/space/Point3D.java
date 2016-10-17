package com.stephenomalley.space;

import java.awt.geom.Point2D;

/**
 * Created by kida_ on 14/10/2016.
 */
public class Point3D extends Point2D.Double {

    public double z;

    public Point3D() {
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

}
