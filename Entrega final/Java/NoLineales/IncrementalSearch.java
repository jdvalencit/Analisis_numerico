package me.DavidLake.AnalisisNumerico.NoLineales;

import me.DavidLake.AnalisisNumerico.Main;

public class IncrementalSearch {

    private static double f(double x){

        return Main.f(x);
    }

    public static void solve(double Xi, double increment){

        double next;
        double fXi = f(Xi);
        double fNext;

        if(fXi == 0){

            System.out.println(fXi + " es raíz");
            return;
        }

        next = Xi + increment;
        fNext = f(next);

        int numeroIteraciones = 1;

        while((fXi * fNext) > 0 && numeroIteraciones < Main.maxIter){

            Xi = next;
            fXi = fNext;

            next = Xi + increment;
            fNext = f(next);

            numeroIteraciones++;
        }

        if(fNext == 0){

            System.out.println(next + " es raíz");
        } else if(fXi * fNext < 0){

            System.out.println("hay una raíz entre "+ Xi +" y " + next);
        } else{

            System.out.println("\nNo se llegó a un resultado en "+numeroIteraciones+" iteraciones.");
        }
    }
}