package me.DavidLake.AnalisisNumerico;

import me.DavidLake.AnalisisNumerico.Factorizacion.Crout;
import me.DavidLake.AnalisisNumerico.Factorizacion.FacUtilities;
import me.DavidLake.AnalisisNumerico.Factorizacion.LU_Gauss;
import me.DavidLake.AnalisisNumerico.GaussElimination.GaussSimple;
import me.DavidLake.AnalisisNumerico.GaussElimination.GaussWithPartialPivot;
import me.DavidLake.AnalisisNumerico.GaussElimination.GaussWithTotalPivot;
import me.DavidLake.AnalisisNumerico.Interpolacion.LagrangeInterpolation;
import me.DavidLake.AnalisisNumerico.Interpolacion.NewtonInterpolation;
import me.DavidLake.AnalisisNumerico.Interpolacion.Splines;
import me.DavidLake.AnalisisNumerico.MetodosIterativos.Jacobi;
import me.DavidLake.AnalisisNumerico.MetodosIterativos.Seidel;
import me.DavidLake.AnalisisNumerico.NoLineales.*;

import java.util.Arrays;

public class Main {

    public static final int maxIter = 100;

    public static void main(String[] args) {

        double[][] a = {{4, -1, 0, 3},{1, 15.5, 3, 8},{0, -1.3, -4, 1.1}, {14, 5, -2, 30}};
        double[] b = {1,1,1,1};
        double[] x0 = {0,0,0,0};
        double tol = 0.0000001;

        double[] x = {-1, 0, 3, 4};
        double[] y = {15.5, 3, 8, 1};

        double[][] testA = {{2, -1, 0, 3}, {1, 0.5, 3, 8}, {0, 13, -2, 11},{14, 5, -2, 3}};
        double[] testB = {1,1,1,1};

        IncrementalSearch.solve(-3, 0.5);

    }

    public static double f(double x){

        return Math.log(Math.pow(Math.sin(x),2)+1)-1.0/2.0; //Aquí va la función
    }

    public static double df(double x){

        return Math.exp(x)-1;  //Aquí va la derivada
    }

    public static double ddf(double x){

        return Math.exp(x); //Aquí va la 2da derivada
    }

    public static double g(double x){

        return Math.log(Math.pow(Math.sin(x), 2)+1) - 1.0/2.0; //Para punto fijo
    }
}
