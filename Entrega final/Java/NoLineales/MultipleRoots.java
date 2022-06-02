package me.DavidLake.AnalisisNumerico.NoLineales;

import me.DavidLake.AnalisisNumerico.Main;

public class MultipleRoots {

    private static double f(double x){

        return Main.f(x);
    }

    private static double df(double x){

        return Main.df(x); //Aquí va la derivada
    }

    private static double ddf(double x){

        return Main.ddf(x); //2da derivada
    }

    public static void solve(double x0, double tol){

        double x = x0;
        double fx = f(x);
        double dfx = df(x);
        double ddfx = ddf(x);
        int actualIterations = 0;

        System.out.printf("\n%4s %15s %22s %25s %22s %22s %27s\n\n", "n", "x1", "f(x1)", "df(x1)", "d2f(x1)","ErrorAbs", "ErrorRelativo");

        double absoluteError = Double.MAX_VALUE;
        double relativeError;

        double den = Math.pow(dfx, 2) - (fx * ddfx);

        System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f %12s %12s\n", actualIterations, x0, fx, dfx, ddfx, "", "");

        while(fx != 0 && absoluteError > tol && den != 0 && actualIterations < Main.maxIter){

            double xn = x - ((fx * dfx) / den);
            fx = f(xn);
            dfx = df(xn);
            ddfx = ddf(xn);

            den = Math.pow(dfx, 2) - (fx * ddfx);

            absoluteError = Math.abs(xn - x);
            relativeError = absoluteError / Math.abs(xn);

            x = xn;
            actualIterations++;

            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f %+1.20f %+1.20f\n", actualIterations, x, fx, dfx, ddfx, absoluteError, relativeError);
        }

        System.out.println();
        if(fx == 0) System.out.println("  " + x + " es una raíz");
        else if(absoluteError < tol) System.out.println("   " + x + " es una aproximación a una raíz con una tolerancia = " + tol);
        else if(den == 0) System.out.println("El denominador es cero (0).");
        else System.out.println("No se llegó en " + Main.maxIter + " iteraciones");
    }
}