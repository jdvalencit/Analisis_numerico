package me.DavidLake.AnalisisNumerico;

public class PartialPivot {

    public static void partialPivot(double[][] ab, int k){

        double largest = Math.abs(ab[k][k]);
        int largest_row = k;
        int n = MatrixUtilities.shape(ab).getValue0();

        for(int r = (k+1); r < n; r++){

            double current = Math.abs(ab[r][k]);
            if(current > largest){

                largest = current;
                largest_row = r;
            }
        }

        if(largest == 0){  }
        else if(largest_row != k) {

            MatrixUtilities.swapRow(ab, k, largest_row);
        }
    }

    public static boolean checkPermutation(double[][] a, double[][] lower_tri, double[][] permutation, int k){

        if(MatrixUtilities.shape(a).getValue0() != MatrixUtilities.shape(permutation).getValue0()) throw new RuntimeException("Las matrices NO se corresponden.");

        double largest = Math.abs(a[k][k]);
        int largest_row = k;
        int size = MatrixUtilities.shape(a).getValue0();

        for(int r = (k+1); r < size; r++){

            double temp = Math.abs(a[r][k]);
            if(temp > largest){

                largest = temp;
                largest_row = r;
            }
        }

        if(largest == 0){ throw new RuntimeException("EL SISTEMA NO TIENE UNICA SOLUCION"); }
        else if(largest_row != k){

            MatrixUtilities.swapRow(a, k, largest_row);
            MatrixUtilities.swapRow(permutation, k, largest_row);

            if(k > 0){

                for(int s = 0; s < k; s++){

                    double temp = lower_tri[largest_row][s];
                    lower_tri[largest_row][s] = lower_tri[k][s];
                    lower_tri[k][s] = temp;
                }
            }
            return true;
        } else return false;
    }
}
