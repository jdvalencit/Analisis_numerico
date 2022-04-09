public class Newton {

    private static double f(double x){

        return Main.f(x);
    }

    private static double df(double x){

        return Main.df(x);
    }

    public static void Calcular(double xi, double tol, int maxIter){

        double x = xi;
        double error = tol + 1;
        double fx = f(x);
        double dfx;
        int iter = 0;

        System.out.printf("\n%4s %10s %10s %12s\n\n", "iter", "x", "f(x)", "Error");

        System.out.printf("|%4d| %10f| %10f| %10s|\n", iter, x, fx, "");

        while (error > tol && fx != 0 && iter < maxIter - 1) {

            dfx = df(x);
            x -= fx/dfx;
            fx = f(x);
            error = xi - x;
            error = Math.abs(error);
            xi = x;
            iter++;

            System.out.printf("|%4d| %10f| %10f| %10f|\n", iter, x, fx, error);
        }

        System.out.printf("\nLa raiz es de f(x) = x * exp(x) - x^2 - 5x - 3; es: %.15f\n", x);
    }
}
