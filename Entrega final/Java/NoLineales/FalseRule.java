package me.DavidLake.AnalisisNumerico.NoLineales;

import me.DavidLake.AnalisisNumerico.Main;

public class FalseRule {

    private static double f(double x){

        return Main.f(x);
    }

    public static void solve(double xi, double xf, double tol){

        double current;
        double xm = 0;
        double fXi = f(xi);
        double fXf = f(xf);
        double fXm;
        double absoluteError = Double.MAX_VALUE;
        int actualIterations = 0;

        System.out.printf("\n%4s %11s %13s %14s %17s %15s\n\n", "iter", "xi", "xs", "xm", "f(xm)", "Error");

        if ( fXi == 0) {

            System.out.printf("\nXi = %.15f es una raíz\n", xi);
        } else if (fXf == 0) {

            System.out.printf("\nXs = %.15f es una raíz\n", xf);
        } else if ((fXi * fXf) < 0) {

            xm = xi - fXi * (xf - xi) / (fXf - fXi);
            fXm = f(xm);

            System.out.printf("%4d %+1.12f %+1.12f %+1.12f %+1.12f %12s\n", actualIterations, xi, xf, xm, fXm, "");

            while (absoluteError > tol && fXm != 0 && actualIterations < Main.maxIter) {

                if (fXi * fXm < 0) {

                    xf = xm;
                    fXf = fXm;
                } else {

                    xi = xm;
                    fXi = fXm;
                }

                current = xm;
                xm = xi - fXi * (xf - xi) / (fXf - fXi);
                fXm = f(xm);
                absoluteError = (xm - current);
                absoluteError = Math.abs(absoluteError);
                actualIterations++;
                System.out.printf("%4d %+1.12f %+1.12f %+1.12f %+1.12f %+1.12f\n", actualIterations, xi, xf, xm, fXm, absoluteError);
            }
        }

        if(actualIterations >= Main.maxIter && absoluteError > tol) System.out.println("\nNo se llegó a un resultado en "+actualIterations+" iteraciones.");
        else System.out.printf("\nLa raiz es: %.15f\n", xm);
    }
}