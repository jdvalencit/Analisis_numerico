package me.DavidLake.AnalisisNumerico.MetodosIterativos;

import me.DavidLake.AnalisisNumerico.Main;

public class Jacobi {

    public static double[] solve(double[][] a, double [] b, double tol, double[] x0){

        int size = a.length;
        double[] x = new double[size];
        double temp;
        int actualIterations = 0;
        double absoluteError = Double.MAX_VALUE;

        while(absoluteError > tol && actualIterations <= Main.maxIter){

            absoluteError = 0;

            for(int i=0;i<size;i++){

                double suma=0;

                for (int j = 0;j < size; j++){

                    if (i != j){

                        suma=suma+a[i][j]*x0[j];
                    }
                }

                x[i] = (b[i] - suma)/a[i][i];
                temp = x[i]-x0[i];
                absoluteError = absoluteError + Math.pow(temp,2);
            }

            absoluteError = Math.pow(absoluteError,0.5);

            System.arraycopy(x, 0, x0, 0, size);

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
