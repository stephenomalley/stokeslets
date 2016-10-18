package com.stephenomalley.space;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kida_ on 17/10/2016.
 */
public class RankTwoTensorTest {

    private RankTwoTensor tensor;
    private RankTwoTensor tensorB;

    @Before
    public void setUp(){
        this.tensor = new RankTwoTensor(2);
        tensorB = new RankTwoTensor(2);
        tensorB.setTensorMatrix(new double[][]{{11, 1}, {6, 12}});
    }

    @Test
    public void testTensorMatrixTwoByTwo() throws Exception {
        double[][] matrix = this.tensor.getTensorMatrix();
        Assert.assertEquals(matrix.length, 2);
    }


    @Test
    public void testDefaultTensorMatrixAllZero() throws Exception {
        RankTwoTensor expected = new RankTwoTensor(new double[][]{{0, 0},{0, 0}});
        Assert.assertEquals(expected, this.tensor);
    }

    @Test
    public void testSetTensorMatrix() throws Exception {

        double[][] expected = new double[4][4];
        expected[3][3] = 11.7;
        this.tensor.setTensorMatrix(expected);
        double[][] actual = this.tensor.getTensorMatrix();

        Assert.assertEquals(expected[3][3], actual[3][3], 0.0);

    }

    @Test
    public void testAddTensor() throws Exception {
        RankTwoTensor actual = this.tensor.add(tensorB);
        Assert.assertEquals(this.tensorB, actual);
    }

    @Test
    public void testAddTensorToNonDefaultTensor()throws Exception{
        this.tensor.setTensorMatrix(new double[][]{{1, 2}, {3, 4}});
        RankTwoTensor actual = this.tensor.add(tensorB);
        Assert.assertEquals(new RankTwoTensor(new double[][]{{12, 3},{9, 16}}), actual);

    }

    @Test
    public void testScalarMultiplicationOfTensor() throws Exception{
        this.tensor.setTensorMatrix(new double[][]{{1, 2}, {3, 4}});
        RankTwoTensor actual = this.tensor.scalarMultiply(2);
        Assert.assertEquals(new RankTwoTensor(new double[][]{{2, 4},{6, 8}}), actual);
    }

}