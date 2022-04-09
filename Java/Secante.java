public class Secante {

    private static double f(double x){

        return Main.f(x);
    }

    public static void Calcular(double x0, double x1, double tol, double maxIter){

        double actual;
        double fx0 = f(x0);
        double fx1;
        double denominador;
        double error = tol + 1;
        double errorRelativo = 0;
        int iter = 0;

        System.out.printf("\n%4s %15s %23s %22s %27s\n\n", "iter", "xn", "f(x)", "Error", "ErrorRelativo");

        if (fx0 == 0) {

            System.out.printf("\nX0 = %f es una Raíz\n", x0);
        } else {

            fx1 = f(x1);
            denominador = fx1 - fx0;
            System.out.printf("%4d %+1.20f %+1.20f %10s %10s\n", iter, x0, fx0, "", "");
            iter++;
            System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f\n", iter, x1, fx1, (x1-x0), (x1-x0)/x1); //Error " "

            while (error > tol && fx1 != 0 && denominador != 0 && iter < maxIter - 1) {

                actual = x1 - fx1 * (x1 - x0) / denominador;
                error = (actual - x1);
                error = Math.abs(error);
                errorRelativo = Math.abs(error/actual);
                x0 = x1;
                fx0 = fx1;
                x1 = actual;
                fx1 = f(x1);
                denominador = fx1 - fx0;
                iter++;
                System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f\n", iter, x1, fx1, error, errorRelativo);
            }
        }

        System.out.printf("\nLa raiz es: %1.20f\n", x1);
    }
}
