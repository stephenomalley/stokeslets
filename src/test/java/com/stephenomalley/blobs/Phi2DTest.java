package com.stephenomalley.blobs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void value1() throws Exception {

    }

}