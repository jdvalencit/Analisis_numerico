package me.DavidLake.AnalisisNumerico;

public class RegressiveSubstitution {

    public static double[] solve(double[][] merge) {

        int size = MatrixUtilities.shape(merge).getValue0();

        if(MatrixUtilities.shape(merge).getValue1() != size + 1) throw new RuntimeException("La matriz NO tiene el tamaño esperado.");

        double[] result = new double[size];
        result[size-1] = merge[size-1][size] / merge[size-1][size-1];

        for(int i = (size-2); i > -1; i--){

            double temp = 0;

            for(int j = (i+1); j < size; j++){

                temp += merge[i][j] * result[j];
            }

            result[i] = (merge[i][size] - temp) / merge[i][i];
        }

        return result;
    }
}
