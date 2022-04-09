public class RaicesMultiples {

    private static double f(double x){

        return Main.f(x);
    }

    private static double df(double x){

        return Main.df(x); //Aquí va la derivada
    }

    private static double d2f(double x){

        return Main.d2f(x); //2da derivada
    }

    public static void Calcular(double x0, double tol, double iter){

        double fx = f(x0);
        double dfx = df(x0);
        double d2fx = d2f(x0);

        System.out.printf("\n%4s %15s %22s %25s %22s %22s %27s\n\n", "n", "x1", "f(x1)", "df(x1)", "d2f(x1)","Error", "ErrorRelativo");

        int contador = 0;
        double error = tol + 1;
        double den = Math.pow(dfx, 2) - (fx*d2fx);
        double x1 = 0;
        double errorRelativo = 0;

        System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f %12s %12s\n", contador, x0, fx, dfx, d2fx, "", "");

        while(error > tol &&  fx != 0 && den != 0 && contador < iter){

            x1 = x0 - ((fx*dfx)/den);
            fx = f(x1);
            dfx = df(x1);
            d2fx = d2f(x1);
            den = Math.pow(dfx, 2) - (fx*d2fx);

            error = Math.abs(x1-x0);
            errorRelativo = Math.abs(error/x0);
            x0 = x1;
            contador++;

            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f %+1.20f %+1.20f\n", contador, x1, fx, dfx, d2fx, error, errorRelativo);
        }

        System.out.println();
        if(fx == 0) System.out.println("  " + x0 + " es una raíz");
        else if(error < tol) System.out.println("   " + x1 + " es una aproximación a una raíz con una tolerancia = " + tol);
        else if(den == 0) System.out.println("El denominador es cero (0).");
        else System.out.println("No se llegó en " + iter + " iteraciones");
    }
}
