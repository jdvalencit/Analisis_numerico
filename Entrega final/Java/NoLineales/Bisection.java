package me.DavidLake.AnalisisNumerico.NoLineales;

import me.DavidLake.AnalisisNumerico.Main;

public class Bisection {

    private static double f(double x){

        return Main.f(x);
    }

    public static void solve(double xi, double xf, double tol){

        double xm = (xi + xf) / 2;
        double absoluteError = tol + 1;
        double relativeError = 0;
        double fXi = f(xi);
        double fXm;
        double fXf = f(xf);
        int actualIterations = 0;

        System.out.printf("\n%4s %15s %22s %24s %24s %23s %24s\n\n", "ite", "xi", "xm", "xf", "f(xm)", "ErrorAbsoluto", "ErrorRelativo");

        if (fXi == 0) System.out.printf("\nXi = %f es una Raíz\n", xi);
        else if (fXf == 0) System.out.printf("\nXf = %f es una Raíz\n", xf);

        if (fXi * fXf < 0) {

            xm = (xi + xf) / 2;
            fXm = f(xm);
            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %1.20f %10s %10s\n", actualIterations, xi, xm, xf, fXm, "", "");

            while (absoluteError > tol && fXm != 0 && actualIterations < Main.maxIter) {

                if (fXi * fXm < 0){

                    xf = xm;
                    fXf = fXm;
                } else{
                    xi = xm;
                    fXi = fXm;
                }

                xm = (xi + xf) / 2;
                fXm = f(xm);
                absoluteError = Math.abs(xm - xi);
                relativeError = Math.abs(absoluteError/xm);
                absoluteError = Math.abs(absoluteError);
                actualIterations++;

                System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f %+1.20f %1.20f\n", actualIterations, xi, xm, xf, fXm, absoluteError, relativeError);
            }
        }

        if(actualIterations >= Main.maxIter && absoluteError > tol) System.out.println("\nNo se llegó a un resultado en "+actualIterations+" iteraciones.");
        else System.out.printf("\nLa raiz es: %.15f\n", xm);
    }
}