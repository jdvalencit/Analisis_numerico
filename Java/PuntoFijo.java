public class PuntoFijo {

    private static final double euler = 2.718281828459;

    private static double f(double x){

        return Main.f(x);
    }

    private static double g(double x){

        return Main.g(x);
    }

    public static void Calcular(double xi, double tol, int maxIter) {

        double x = xi;
        double fx = f(x);
        double error = tol + 1;
        double errorRelativo = 0;
        int iter = 0;

        System.out.printf("\n%4s %15s %22s %25s %25s\n\n", "iter", "x", "f(x)", "Error", "ErrorRelativo");

        System.out.printf("%4d %+1.20f %+1.20f %12s %12s\n", iter, x, fx, "", "");

        while (error > tol && fx != 0 && iter < maxIter - 1) {

            x = g(xi);
            fx = f(x);
            error = x-xi;
            errorRelativo = Math.abs(error/x);
            error = Math.abs(error);
            xi = x;
            iter++;

            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f\n", iter, x, fx, error, errorRelativo);
        }

        System.out.printf("\nLa raiz es: %.15f\n", x);
    }
}
