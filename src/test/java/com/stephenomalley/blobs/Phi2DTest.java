package com.stephenomalley.blobs;

import com.stephenomalley.space.RankTwoTensor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

/**
 * Created by kida_ on 14/10/2016.
 */
public class Phi2DTest {

    private Phi2D blob;

    @Before
    public void setUp() throws Exception {
        this.blob = new Phi2D(1.0);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValueReturnsCorrectly() throws Exception {
        double actual = this.blob.value(1);
        Assert.assertEquals(0.084, actual, 0.001);
    }

    @Test
    public void testValueReturnsCorrectlyWhenEpsilonModified() throws Exception {
        this.blob.setEpsilon(5);
        double actual = this.blob.value(1);
        Assert.assertEquals(0.017, actual, 0.001);
    }

    @Test
    public void testGetEpsilonReturnsCorrectValue() throws Exception {
        Assert.assertEquals(this.blob.getEpsilon(), 1.0, 0);
    }

    @Test
    public void testGetMagnitudeReturnsSqrtTwo() throws Exception{
        Point2D.Double x = new Point2D.Double(1,0);
        Point2D.Double x0 = new Point2D.Double(0,1);
        Assert.assertEquals(Math.sqrt(2), this.blob.magnitude(x, x0), 0);
    }

    @Test
    public void testGetMagnitudeReturnsZero() throws Exception{
        Point2D.Double x = new Point2D.Double(0,0);
        Point2D.Double x0 = new Point2D.Double(0,0);
        Assert.assertEquals(0, this.blob.magnitude(x, x0), 0);
    }

    @Test
    public void testGetMagnitude() throws Exception{
        Point2D.Double x = new Point2D.Double(4,8);
        Point2D.Double x0 = new Point2D.Double(1,3);
        Assert.assertEquals(Math.sqrt(34), this.blob.magnitude(x, x0), 0);
    }

    @Test
    public void testGreensFunctionGWithMagnitudeZero(){
        Assert.assertEquals(Math.log(1), this.blob.greensFunctionG(0), 0.001);
    }

    @Test
    public void testGreensFunctionGNonZeroMagnitude(){
        Assert.assertEquals(0.085, this.blob.greensFunctionG(1), 0.001);
    }

    @Test
    public void testGreensFunctionBWithZeroMagnitude(){
        Assert.assertEquals(Math.log(2.0)/(4*Math.PI), this.blob.greensFunctionB(0), 0);
    }

    @Test
    public void testDyDxGreensFunctionBAtOrigin(){
        Point2D.Double x = new Point2D.Double(0,0);
        Point2D.Double x0 = new Point2D.Double(0,0);
        RankTwoTensor tensor = this.blob.dxdyGreensFunctionB(x, x0);
        Assert.assertArrayEquals(new double[]{-0.61, 0}, tensor.getTensorMatrix()[0], 0.01);
        Assert.assertArrayEquals(new double[]{0, -0.61}, tensor.getTensorMatrix()[1], 0.01);
    }

    @Test
    public void testDyDxGreensFunctionBW(){
        Point2D.Double x = new Point2D.Double(0,1);
        Point2D.Double x0 = new Point2D.Double(1,0);
        RankTwoTensor actual = this.blob.dxdyGreensFunctionB(x, x0);
        Assert.assertArrayEquals(new double[]{0.01, 0}, actual.getTensorMatrix()[0], 0.001);
        Assert.assertArrayEquals(new double[]{-0.422, 0.01}, actual.getTensorMatrix()[1], 0.001);
    }

}