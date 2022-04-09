public class Biseccion {

    private static double f(double x){

        return Main.f(x);
    }

    public static void Calcular(double xi, double xf, double tol){

        double xm = (xi + xf) / 2;
        double error = tol + 1;
        double errorRelativo = 0;
        double funcionXI = f(xi);
        double funcionXM;
        double funcionXF = f(xf);
        int maxIteraciones = 100, numeroIteraciones = 0;

        System.out.printf("\n%4s %15s %22s %24s %24s %23s %24s\n\n", "ite", "xi", "xm", "xf", "f(xm)", "Error", "ErrorRelativo");

            if (funcionXI == 0) System.out.printf("\nXi = %f es una Raíz\n", xi);
            else if (funcionXF == 0) System.out.printf("\nXf = %f es una Raíz\n", xf);

            if (funcionXI * funcionXF < 0) {

                xm = (xi + xf) / 2;
                funcionXM = f(xm);
                System.out.printf("%4d %+1.20f %+1.20f %+1.20f %1.20f %10s %10s\n", numeroIteraciones, xi, xm, xf, funcionXM, "", "");

                while (error > tol && funcionXM != 0 && numeroIteraciones < maxIteraciones - 1) {

                    if (funcionXI * funcionXM < 0){

                        xf = xm;
                        funcionXF = funcionXM;
                } else{
                        xi = xm;
                        funcionXI = funcionXM;
                }

                    xm = (xi + xf) / 2;
                    funcionXM = f(xm);
                    error = Math.abs(xm - xi);
                    errorRelativo = Math.abs(error/xm);
                    error = Math.abs(error);
                    numeroIteraciones++;

                    System.out.printf("%4d %+1.20f %+1.20f %+1.20f %+1.20f %+1.20f %1.20f\n", numeroIteraciones, xi, xm, xf, funcionXM, error, errorRelativo);
            }
        }

        System.out.printf("\nLa raiz es: %.15f\n", xm);
    }
}
