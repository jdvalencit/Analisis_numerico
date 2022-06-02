package me.DavidLake.AnalisisNumerico.Interpolacion;

public class NewtonInterpolation {

    public static double solve(double[] x, double[] y, double guess){

        int size = x.length;
        double[][] result = new double[size][size];

        for (int i = 0;i < size; i++){

            result[i][0] = y[i];
        }

        double res;

        for (int j = 0; j < (size-1); j++){

            res=0;

            for(int i = j+1;i<size;i++){

                result[i][j+1] = (result[i][j] - result[i-1][j]) / (x[i] - x[(int)res]);
                res++;
            }
        }

        res = 0;
        double temp;

        for(int i = 0;i < size; i++){

            temp = 1;

            for(int j = 0; j < i;j++){

                temp = temp * (guess - x[j]);
            }

            res = res + result[i][i] * temp;
        }

        return res;
    }
}
