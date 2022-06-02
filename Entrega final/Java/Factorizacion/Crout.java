package me.DavidLake.AnalisisNumerico.Factorizacion;

import me.DavidLake.AnalisisNumerico.MatrixUtilities;
import org.javatuples.Pair;

public class Crout {

    public static Pair<double[][], double[][]> solve(double[][] a){

        int size = MatrixUtilities.shape(a).getValue0();

        double[][] lower_tri = MatrixUtilities.identity(size);
        double[][] upper_tri = MatrixUtilities.identity(size);

        for(int k = 0; k < size; k++) {

            double firstSum = 0;

            for(int p = 0; p < k; p++) {

                firstSum += lower_tri[k][p] * upper_tri[p][k];
            }

            lower_tri[k][k] = a[k][k] - firstSum;

            for(int i = (k+1); i < size; i++){

                double secondSum = 0;

                for(int p = 0; p < k; p++) {

                    secondSum += lower_tri[i][p] * upper_tri[p][k];
                }

                lower_tri[i][k] = a[i][k] - secondSum;
            }

            for(int j = (k+1); j < size; j++){

                double thirdSum = 0;

                for(int p = 0; p < k; p++){

                    thirdSum += lower_tri[k][p] * upper_tri[p][j];
                }

                upper_tri[k][j] = (a[k][j] - thirdSum) / lower_tri[k][k];
            }
        }

        return new Pair<>(lower_tri, upper_tri);
    }
}
