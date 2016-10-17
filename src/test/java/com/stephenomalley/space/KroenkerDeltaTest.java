package com.stephenomalley.space;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kida_ on 17/10/2016.
 */
public class KroenkerDeltaTest {

    KroenkerDelta delta;
    @Before
    public void setUp() throws Exception {
        this.delta = new KroenkerDelta();
    }

    @Test
    public void testKroenekerDeltaConstructedCorrectly(){
        double[] row0 = {1.0, 0.0};
        double[] row1 = {0.0, 1.0};
        double[][] actual = this.delta.getTensorMatrix();
        Assert.assertArrayEquals(row0, actual[0], 0);
        Assert.assertArrayEquals(row1, actual[1],0);
    }

}