public class Main {

    /*

    Clase desde la que se corren los métodos y se establecen las funciones que estos utilizaran.

     */

    public static void main(String[] args) {

        Newton.Calcular(2, 0.00000001, 100);
    }

    public static double f(double x){

        return Math.sin(x+3)-Math.log(x+1)+Math.pow(x,2)-3; //Aquí va la función
    }

    public static double df(double x){

        return 2*x+Math.cos(x+3)-(1/(x+1)); //Aquí va la derivada
    }

    public static double d2f(double x){

        return Math.exp(x) + x*Math.exp(x); //Aquí va la 2da derivada
    }

    public static double g(double x){

        return -Math.exp(-2*x-5+Math.pow(x,2))/2; //Para punto fijo
    }
}
