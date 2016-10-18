package com.stephenomalley.space;

import java.util.Arrays;

/**
 * Created by kida_ on 18/10/2016.
 */
public class MeshGrid {
    private double[][] xGrid;
    private double[][] yGrid;

    public MeshGrid(int[] x, int[] y){
        generateGrid(x, y);
    }

    public void generateGrid(int[] x, int[] y) {
        int N = x.length;
        int M = y.length;
        double[][] grid = new double[N][M];
        for (int i = 0; i < N; i++) {
            double[] tmp = new double[M];
            Arrays.fill(tmp, x[i]);
            grid[i] = tmp;
        }
        this.xGrid = grid;

        grid = new double[M][N];
        for (int i = 0; i < M; i++) {
            double[] tmp = new double[N];
            Arrays.fill(tmp, y[i]);
            grid[i] = tmp;
        }
        this.yGrid = grid;
    }

    public double[][] getxGrid() {
        return xGrid;
    }

    public void setxGrid(double[][] xGrid) {
        this.xGrid = xGrid;
    }

    public double[][] getyGrid() {
        return yGrid;
    }

    public void setyGrid(double[][] yGrid) {
        this.yGrid = yGrid;
    }
}
