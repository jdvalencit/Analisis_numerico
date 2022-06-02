package me.DavidLake.AnalisisNumerico.Interpolacion;

public class LagrangeInterpolation {

    public static double solve(double[] x, double[] y, double guess){

        double sum = 0;
        double product = 1;
        int size = x.length;

        for(int i = 0; i < size; i++){

            for(int j = 0; j < size; j++){

                if(j != i){

                    product *= (guess - x[j]) / (x[i] - x[j]);
                }
            }

            sum += product * y[i];

            product = 1;
        }

        return sum;
    }
}
