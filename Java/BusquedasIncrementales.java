public class BusquedasIncrementales {

    private static double f(double x){

        return Main.f(x);
    }

    private static void Calcular(double inicial, int maxIteraciones, double incremento){

        double siguiente;
        double funcionInicial = f(inicial);
        double funcionSiguiente;

        if(funcionInicial == 0){

            System.out.println(funcionInicial + " es raíz");
            return;
        }

        siguiente = inicial + incremento;
        funcionSiguiente = f(siguiente);

        int iterActual = 1;

        while((funcionInicial * funcionSiguiente) > 0 && iterActual < maxIteraciones){

            inicial = siguiente;
            funcionInicial = funcionSiguiente;

            siguiente = inicial + incremento;
            funcionSiguiente = f(siguiente);

            iterActual++;
        }

        if(funcionSiguiente == 0){

            System.out.println(siguiente + " es raíz");
        } else if(funcionInicial * funcionSiguiente < 0){

            System.out.println("hay una raíz entre x0 y x1");
        } else{

            System.out.println("no se encontró respuesta en " + maxIteraciones + " iteraciones");
        }
    }
}
