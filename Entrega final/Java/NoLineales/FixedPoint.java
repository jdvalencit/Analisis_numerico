package me.DavidLake.AnalisisNumerico.NoLineales;

import me.DavidLake.AnalisisNumerico.Main;

public class FixedPoint {

    private static final double euler = 2.718281828459;

    private static double f(double x){

        return Main.f(x);
    }

    private static double g(double x){

        return Main.g(x);
    }

    public static void solve(double xi, double tol) {

        double x = xi;
        double fx = f(x);
        int actualIterations = 0;

        double absoluteError = Double.MAX_VALUE;
        double relativeError;

        System.out.printf("\n%4s %13s %24s %25s %25s\n\n", "iter", "x", "f(x)", "ErrorAbs", "ErrorRel");

        System.out.printf("%4d %+1.20f %+1.20f %12s %12s\n", actualIterations, x, fx, "", "");

        while (fx != 0 && absoluteError > tol && actualIterations < Main.maxIter) {

            double xn = g(x);
            fx = f(xn);

            absoluteError = Math.abs(xn - x);
            relativeError = absoluteError / Math.abs(xn);

            x = xn;
            actualIterations++;

            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f\n", actualIterations, x, fx, absoluteError, relativeError);
        }

        if(actualIterations >= Main.maxIter && absoluteError > tol) System.out.println("\nNo se llegó a un resultado en "+actualIterations+" iteraciones.");
        else System.out.printf("\nLa raiz es: %.15f\n", x);
    }
}