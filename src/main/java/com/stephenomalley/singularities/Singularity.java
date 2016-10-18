package com.stephenomalley.singularities;

import com.stephenomalley.space.RankTwoTensor;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by kida_ on 14/10/2016.
 */
public abstract class Singularity {

    public abstract RankTwoTensor getTensor();

}
