package com.stephenomalley.singularities;

import com.stephenomalley.blobs.Phi;
import com.stephenomalley.space.RankTwoTensor;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by kida_ on 14/10/2016.
 */
public class Stokeslet extends Singularity {

    private Phi cutoff;

    public Stokeslet() {

    }


    public static void main(String args[]) {
        Stokeslet s = new Stokeslet();
    }

    public RankTwoTensor getTensor() {
        return null;
    }

    public Phi getCutoff() {
        return cutoff;
    }

    public void setCutoff(Phi cutoff) {
        this.cutoff = cutoff;
    }
}
