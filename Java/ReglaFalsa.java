public class ReglaFalsa {

    private static double f(double x){

        return Main.f(x);
    }

    public static void Calcular(double xi, double xf, double tol, double maxIter){

        double actual;
        double xm = 0;
        double fxi = f(xi);
        double fxf = f(xf);
        double fxm;
        double error = tol + 1;
        int iter = 0;

        System.out.printf("\n%4s %11s %13s %14s %17s %15s\n\n", "iter", "xi", "xs", "xm", "f(xm)", "Error");

        if ( fxi == 0) {

            System.out.printf("\nXi = %.15f es una raíz\n", xi);
        } else if (fxf == 0) {

            System.out.printf("\nXs = %.15f es una raíz\n", xf);
        } else if ((fxi * fxf) < 0) {

            xm = xi - fxi * (xf - xi) / (fxf - fxi);
            fxm = f(xm);

            System.out.printf("%4d %+1.12f %+1.12f %+1.12f %+1.12f %12s\n", iter, xi, xf, xm, fxm, "");

            while (error > tol && fxm != 0 && iter < maxIter - 1) {

                if (fxi * fxm < 0) {

                    xf = xm;
                    fxf = fxm;
                } else {

                    xi = xm;
                    fxi = fxm;
                }

                actual = xm;
                xm = xi - fxi * (xf - xi) / (fxf - fxi);
                fxm = f(xm);
                error = (xm - actual);
                error = Math.abs(error);
                iter++;
                System.out.printf("%4d %+1.12f %+1.12f %+1.12f %+1.12f %+1.12f\n", iter, xi, xf, xm, fxm, error);
            }
        }

        System.out.printf("\nLa raiz es: %.15f\n", xm);
    }
}
