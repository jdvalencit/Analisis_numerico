package me.DavidLake.AnalisisNumerico.NoLineales;

import me.DavidLake.AnalisisNumerico.Main;

public class Secant {

    private static double f(double x){

        return Main.f(x);
    }

    public static void solve(double x0, double x1, double tolerancia){

        if(x1 <= x0){
            System.out.println("Intervalo no válido.");
            return;
        }

        double fx0 = f(x0);
        int actualIterations = 0;
        double absoluteError = Double.MAX_VALUE;
        double relativeError;

        System.out.printf("\n%4s %15s %23s %22s %27s\n\n", "iter", "xn", "f(x)", "ErrorAbs", "ErrorRelativo");

        if (fx0 == 0) {

            System.out.printf("\nX0 = %f es una Raíz\n", x0);
        } else {

            double fx1 = f(x1);
            double denominator = fx1 - fx0;
            actualIterations++;

            System.out.printf("%4d %+1.20f %+1.20f %10s %10s\n", actualIterations, x0, fx0, "", "");
            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f\n", actualIterations, x1, fx1, (x1-x0), (x1-x0)/x1); //Error " "

            while (absoluteError > tolerancia && fx1 != 0 && denominator != 0 && actualIterations < Main.maxIter) {

                double x2 = x1 - ((fx1 * (x1 - x0)) / denominator);
                absoluteError = Math.abs(x2 - x1);
                relativeError = absoluteError / Math.abs(x2);

                x0 = x1;
                fx0 = fx1;
                x1 = x2;
                fx1 = f(x1);

                denominator = fx1 - fx0;
                actualIterations++;

                System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f\n", actualIterations, x1, fx1, absoluteError, relativeError);
            }
        }

        if(actualIterations >= Main.maxIter && absoluteError > tolerancia) System.out.println("\nNo se llegó a un resultado en "+actualIterations+" iteraciones.");
        else System.out.printf("\nLa raiz es: %.15f\n", x1);
    }
}