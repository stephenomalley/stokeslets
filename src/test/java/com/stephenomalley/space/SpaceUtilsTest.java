package com.stephenomalley.space;

import com.stephenomalley.exceptions.InvalidSupportMatrixSize;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kida_ on 18/10/2016.
 */
public class SpaceUtilsTest {

    @Test
    public void testLinspace() throws Exception{
        double[] actual = SpaceUtils.linspace(0,1,5);
        Assert.assertArrayEquals(new double[]{0,0.25,0.5,0.75,1}, actual, 0);
    }

    @Test
    public void testSupportMatrix2D() throws Exception{
        RealMatrix actual = SpaceUtils.supportMatrix2D(2);
        RealMatrix expected = MatrixUtils.createRealMatrix(new double[][]{{1, 0, 1, 0},{0, 1, 0, 1}});
        Assert.assertEquals(expected, actual);
    }


    @Test(expected = InvalidSupportMatrixSize.class)
    public void testSupportMatrix2DNZero() throws Exception{
        SpaceUtils.supportMatrix2D(0);
    }


}