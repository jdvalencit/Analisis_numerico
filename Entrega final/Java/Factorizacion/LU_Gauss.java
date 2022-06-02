package me.DavidLake.AnalisisNumerico.Factorizacion;

import me.DavidLake.AnalisisNumerico.MatrixUtilities;

public class LU_Gauss {

    public static double[][] solve(double[][] a){

        if(MatrixUtilities.shape(a).getValue0() != MatrixUtilities.shape(a).getValue1()) throw new RuntimeException("La matriz NO es cuadrada.");

        int size = MatrixUtilities.shape(a).getValue0();

        double[][] lower_tri = MatrixUtilities.identity(size);

        for(int k = 0; k < (size-1); k++){

            for(int i = (k+1); i < size; i++){

                double multiplier = a[i][k] / a[k][k];

                for(int j = k; j < size; j++){

                    a[i][j] = a[i][j] - (multiplier * a[k][j]);

                    if(i > j) lower_tri[i][j] = multiplier;
                }
            }
        }

        return lower_tri;
    }
}
