package com.stephenomalley.space;

import java.awt.geom.Point2D;

/**
 * Created by kida_ on 14/10/2016.
 */
public class Point3D extends Point2D.Float {

    public float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setLocation(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

}
