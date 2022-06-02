package me.DavidLake.AnalisisNumerico;

public class ProgressiveSubstitution {

    public static double[] solve(double[][] merge){

        int size = MatrixUtilities.shape(merge).getValue0();

        if(MatrixUtilities.shape(merge).getValue1() != size + 1) throw new RuntimeException("La matriz NO tiene el tamaño esperado.");

        double[] result = new double[size];
        result[0] = merge[0][size] / merge[0][0];

        for(int i = 1; i < size; i++){

            double temp = 0;

            for(int p = 0; p < i; p++){

                temp += merge[i][p] * result[p];
            }

            result[i] = (merge[i][size] - temp) / merge[i][i];
        }

        return result;
    }
}
