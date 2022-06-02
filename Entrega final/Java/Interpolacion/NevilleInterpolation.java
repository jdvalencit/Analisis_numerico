package me.DavidLake.AnalisisNumerico.Interpolacion;

public class NevilleInterpolation {

    public static double solve(double[] x, double[] y, double guess){

        int size = x.length;
        double[][] result = new double[size][size];

        for (int j=0; j < size; j++) result[j][0]=y[j];

        int temp;

        for (int k=0; k<size-1;k++){

            temp = 0;

            for(int i = (k+1); i < size; i++){

                result[i][k+1] = (((guess - x[temp]) * result[i][k]) - ((guess - x[i]) * result[i-1][k])) / (x[i] - x[temp]);
                temp++;
            }
        }

        return result[size-1][size-1];
    }
}
