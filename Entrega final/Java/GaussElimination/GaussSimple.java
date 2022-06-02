package me.DavidLake.AnalisisNumerico.GaussElimination;

import me.DavidLake.AnalisisNumerico.MatrixUtilities;

import java.util.Arrays;
import java.util.Objects;

public class GaussSimple {

    public static double[][] solve(double[][] a, double[] b) {

        double[][] merge = MatrixUtilities.to_aug(a, b);

        if(!Objects.equals(MatrixUtilities.shape(a).getValue0(), MatrixUtilities.shape(a).getValue1())) throw new RuntimeException("La matriz NO es cuadrada.");

        int size = MatrixUtilities.shape(a).getValue0();

        for (int k = 0; k < (size - 1); k++) {

            for (int i = (k + 1); i < size; i++) {

                double multiplier = merge[i][k] / merge[k][k];

                for (int j = k; j < (size + 1); j++) {

                    merge[i][j] = merge[i][j] - (multiplier * merge[k][j]);
                }
            }
        }

        return merge;
    }

}
