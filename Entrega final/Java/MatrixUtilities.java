package me.DavidLake.AnalisisNumerico;

import org.javatuples.Pair;

public class MatrixUtilities {

    public static Pair<Integer, Integer> shape(double[][] matriz){

        return new Pair<Integer, Integer>(matriz.length, matriz[0].length);
    }

    public static double[][] to_aug(double[][] array1, double[] array2){

        double[][] result = new double[array1.length][array1[0].length+1];

        for(int i = 0; i < result.length; i++){

            if (result[0].length - 1 >= 0) System.arraycopy(array1[i], 0, result[i], 0, result[0].length - 1);

            result[i][result[0].length-1] = array2[i];
        }

        return result;
    }

    public static double[][] identity(int n){

        double[][] result = new double[n][n];

        for(int i = 0; i < n; i++){

            result[i][i] = 1;
        }

        return result;
    }

    public static void printMatrix(double[][] a){

        for (double[] doubles : a) {

            for (int k = 0; k < a[0].length; k++) {

                System.out.print(doubles[k] + " ");
            }

            System.out.println();
        }
    }

    public static double[] diagonal(double[][] a){

        int n = shape(a).getValue0();

        double[] result = new double[n];

        for(int i = 0; i < n; i++){

            result[i] = a[i][i];
        }

        return result;
    }

    public static double prod(double[] a){

        double result = a[0];

        for(int i = 1; i < a.length; i++){

            result *= a[i];
        }

        return result;
    }

    public static void swapRow(double[][] a, int x1, int x2){

        double temp = 0;

        for(int i = 0; i < a[0].length; i++){

             temp = a[x1][i];
             a[x1][i] = a[x2][i];
             a[x2][i] = temp;
        }
    }

    public static void swapColumn(double[][] a, int x1, int x2){

        double temp = 0;

        for(int i = 0; i < a.length; i++){

            temp = a[i][x1];
            a[i][x1] = a[i][x2];
            a[i][x2] = temp;
        }
    }

    public static void swapLabels(String[] a, int x1, int x2){

        String temp = "";

        temp = a[x1];
        a[x1] = a[x2];
        a[x2] = temp;
    }

    public static String[] generateLabels(int n){

        String[] res = new String[n];

        for(int i = 0; i < n; i++){

            res[i] = "x".concat(String.valueOf(i));
        }

        return res;
    }

    public static double[] substractMatrix(double[] a, double[] b){

        double[] resultado = new double[a.length];

        for (int x=0; x < resultado.length; x++) {

            resultado[x] = a[x] - b[x];
        }

        resultado = getAbs(resultado);

        return resultado;
    }

    public static double[] getAbs(double[] a){

        double[] res = new double[a.length];

        for(int i = 0; i < a.length; i++){

            res[i] = Math.abs(a[i]);
        }

        return res;
    }

    public static double getMaxValue(double[] a){

        double result = Double.MIN_VALUE;

        for (double v : a) {

            if (v > result) result = v;
        }

        return result;
    }

    public static double[] dot(double[][] a, double[] b){

        double[] res = new double[a.length];

        for(int i = 0; i < res.length; i++){

            res[i] = a[i][i];
        }

        for(int i = 0; i < res.length; i++){

            for(int k = 0; k < res.length; k++){

                if(a[i][k] == 1) res[i] = b[k];
            }
        }

        return res;
    }

    public static double[] power(double[] x, int pow){

        double[] res = new double[x.length];
        for(int i = 0; i < x.length; i++) res[i] = Math.pow(x[i], pow);

        return res;
    }
}
