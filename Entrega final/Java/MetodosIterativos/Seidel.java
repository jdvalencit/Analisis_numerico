package me.DavidLake.AnalisisNumerico.MetodosIterativos;

import me.DavidLake.AnalisisNumerico.Main;

public class Seidel {

    public static double[] solve(double[][] a, double [] b, double tol, double[] x0) {

        int size = a.length;

        double[] x = new double[size];
        double temp;
        int actualIterations = 0;
        double absoluteError = Double.MAX_VALUE;

        while(absoluteError > tol && actualIterations <= Main.maxIter){

            absoluteError = 0;

            for(int i = 0;i < size;i++){

                double suma = 0;

                for (int j = 0;j < size; j++){

                    if (i != j){

                        suma = suma + a[i][j] * x0[j];
                    }
                }
                x[i] = (b[i] - suma) / a[i][i];
                temp = x[i] - x0[i];
                absoluteError = absoluteError + Math.pow(temp,2);
                x0[i] = x[i];
            }

            absoluteError = Math.pow(absoluteError,0.5);
            actualIterations++;
        }
        if(absoluteError < tol){

            return x;
        }else{

            System.out.println("No se llegó a un resultado en "+Main.maxIter+" iteraciones");
            return new double[0];
        }
    }
}
