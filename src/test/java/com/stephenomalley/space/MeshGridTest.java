package com.stephenomalley.space;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kida_ on 18/10/2016.
 */
public class MeshGridTest {

    private MeshGrid meshGrid;


    @Test
    public void testGenerateGrid() throws Exception {
        meshGrid = new MeshGrid(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(meshGrid.getxGrid().length,3);
        Assert.assertEquals(meshGrid.getxGrid()[0].length,5);
        Assert.assertEquals(meshGrid.getyGrid().length,5);
        Assert.assertEquals(meshGrid.getyGrid()[0].length,3);
    }

}