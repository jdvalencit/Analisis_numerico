package me.DavidLake.AnalisisNumerico.Factorizacion;

import me.DavidLake.AnalisisNumerico.MatrixUtilities;
import me.DavidLake.AnalisisNumerico.PartialPivot;
import org.javatuples.Triplet;

public class LU_Partial_Pivot {

    public static Triplet<double[][], double[][], Double> solve(double[][] a){

        if(MatrixUtilities.shape(a).getValue0() != MatrixUtilities.shape(a).getValue1()) throw new RuntimeException("La matriz NO es cuadrada.");

        double cambios = 0;
        int size = MatrixUtilities.shape(a).getValue0();
        double[][] permutation = MatrixUtilities.identity(size);
        double[][] lower_tri = MatrixUtilities.identity(size);

        for(int k = 0; k < (size-1); k++){

            if(PartialPivot.checkPermutation(a, lower_tri, permutation, k)) cambios += 1;

            for(int i = (k + 1); i < size; i++){

                double multiplier = a[i][k] / a[k][k];

                for(int j = k; j < size; j++){

                    a[i][j] = a[i][j] - (multiplier * a[k][j]);

                    if(i > j){

                        lower_tri[i][j] = multiplier;
                    }
                }
            }
        }

        return new Triplet<>(lower_tri, permutation, cambios);
    }
}
