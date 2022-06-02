package me.DavidLake.AnalisisNumerico.GaussElimination;

import me.DavidLake.AnalisisNumerico.Factorizacion.LU_Partial_Pivot;
import me.DavidLake.AnalisisNumerico.MatrixUtilities;
import me.DavidLake.AnalisisNumerico.PartialPivot;
import org.javatuples.Triplet;

public class GaussWithPartialPivot {

    public static double[][] solve(double[][] a, double[] b){

        double[][] merge = MatrixUtilities.to_aug(a, b);

        if(MatrixUtilities.shape(a).getValue0() != MatrixUtilities.shape(a).getValue1()) throw new RuntimeException("La matriz NO es cuadrada.");

        int size = MatrixUtilities.shape(a).getValue0();

        for(int k = 0; k < (size-1); k++){

            PartialPivot.partialPivot(merge, k);

            for(int i = (k+1); i < size; i++){

                double multiplier = merge[i][k] / merge[k][k];

                for(int j = k; j < (size+1); j++){

                    merge[i][j] = merge[i][j] - (multiplier * merge[k][j]);
                }
            }
        }

        return merge;
     }

     public static double determinant_computation(double[][] a){

        Triplet<double[][], double[][], Double> luFac = LU_Partial_Pivot.solve(a);
        double[][] lower_tri = luFac.getValue0();
        double q = luFac.getValue2();

        double det_l = MatrixUtilities.prod(MatrixUtilities.diagonal(lower_tri));
        double det_u = MatrixUtilities.prod(MatrixUtilities.diagonal(a));

        return Math.pow(-1, q) * det_l * det_u;
     }
}
