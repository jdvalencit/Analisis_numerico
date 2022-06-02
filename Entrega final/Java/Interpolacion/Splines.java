package me.DavidLake.AnalisisNumerico.Interpolacion;

import me.DavidLake.AnalisisNumerico.GaussElimination.GaussWithPartialPivot;
import me.DavidLake.AnalisisNumerico.RegressiveSubstitution;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.ArrayList;

public class Splines {

    public static Pair<ArrayList<Triplet<Double, Double, Double>>, ArrayList<Pair<Double, Double>>> solve_linear(double[] x, double[] y) {

        int interAmount = x.length-1;
        ArrayList<Pair<Double, Double>> intervals = new ArrayList<>();
        ArrayList<Triplet<Double, Double, Double>> equations = new ArrayList<>();

        for(int i = 0; i < interAmount; i++){

            double currentX = x[i];
            double currentY = y[i];
            double nextX = x[i+1];
            double nextY = y[i+1];
            double calc = (nextY - currentY) / (nextX - currentX);

            intervals.add(new Pair<>(currentX, nextX));
            equations.add(new Triplet<>(currentY, calc, currentX));
        }

        return new Pair<>(equations, intervals);
    }

    public static Pair<double[], ArrayList<Pair<Double, Double>>> solve_quadratic(double[] x, double[] y) {

        int interAmount = x.length-1;
        int dim = (interAmount * 2) - 1;
        double[] zvals = new double[dim];
        double[][] system = new double[dim][dim];
        ArrayList<Pair<Double, Double>> intervals = new ArrayList<>();
        ArrayList<Double> hs = new ArrayList<>();

        int col_shift = 0;

        for(int i = 0; i < interAmount; i++){

            double x0 = x[i];
            double f0 = y[i];
            double x1 = x[i+1];
            double f1 = y[i+1];

            intervals.add(new Pair<>(x0, x1));
            double h = x1 - x0;

            system[i][col_shift] = h;

            if(i == 0) col_shift += 1;
            else{

                system[i][col_shift + 1] = Math.pow(h, 2);
                col_shift += 2;
            }

            hs.add(h);
            zvals[i] = f1 - f0;
        }

        col_shift = 0;

        for(int i = interAmount; i < dim; i++){

            system[i][col_shift] = 1;

            if(i == interAmount){

                system[i][col_shift+1] = -1;
                col_shift += 1;
            } else{

                system[i][col_shift + 1] = 2 * hs.get(i - interAmount);
                system[i][col_shift + 2] = -1;
                col_shift += 2;
            }
        }

        double[][] ab = GaussWithPartialPivot.solve(system, zvals);
        double[] sols = RegressiveSubstitution.solve(ab);

        return new Pair<>(sols, intervals);
    }

    public static void printLinearSolution(ArrayList<Triplet<Double, Double, Double>> equations, ArrayList<Pair<Double, Double>> intervals){

        int size = intervals.size();

        for(int i = 0; i < size; i++){

            System.out.print("s" + i + " = " + equations.get(i).getValue0() + " + " + equations.get(i).getValue1() + "(x - " + equations.get(i).getValue2() + ") interval: ");
            System.out.println(intervals.get(i));
        }
    }

    public static void printQuadraticSolution(double[] sols, double[] x, double[] y, ArrayList<Pair<Double, Double>> intervals){

        int i = 0;
        int k = 0;
        int size = sols.length;

        while (k < size) {

            double ai = y[i];
            double bi = sols[k];
            double ci;
            double xi = intervals.get(i).getValue0();

            if (i == 0) {

                ci = 0;
                k += 1;
            } else {

                ci = sols[k + 1];
                k += 2;
            }

            if (ci == 0) {

                System.out.print("s" + i + " = " + ai + " + " + bi + "(x - " + xi + ") interval: ");
                System.out.println(intervals.get(i));
            } else {

                System.out.print("s" + i + " = " + ai + " + " + bi + "(x - " + xi + ") + " + ci + "(x - " + xi + ")^2 interval: ");
                System.out.println(intervals.get(i));
            }

            i++;
        }
    }
}
