package me.DavidLake.AnalisisNumerico.GaussElimination;

import me.DavidLake.AnalisisNumerico.MatrixUtilities;
import me.DavidLake.AnalisisNumerico.TotalPivot;
import org.javatuples.Pair;

public class GaussWithTotalPivot {

    public static Pair<double[][], String[]> solve(double[][] a, double[] b){

        double[][] merge = MatrixUtilities.to_aug(a,b);

        if(MatrixUtilities.shape(a).getValue0() != MatrixUtilities.shape(a).getValue1()) throw new RuntimeException("La matriz NO es cuadrada.");

        int size = MatrixUtilities.shape(merge).getValue0();
        String[] labels = MatrixUtilities.generateLabels(size);

        for(int k = 0; k < (size-1); k++){

            TotalPivot.totalPivot(merge, k, labels);

            for(int i = (k+1); i < size; i++){

                double multiplier = merge[i][k] / merge[k][k];

                for(int j = k; j < (size+1); j++){

                    merge[i][j] = merge[i][j] - (multiplier * merge[k][j]);
                }
            }
        }

        return new Pair<>(merge, labels);
    }
}
