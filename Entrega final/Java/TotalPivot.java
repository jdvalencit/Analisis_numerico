package me.DavidLake.AnalisisNumerico;

public class TotalPivot {

    public static void totalPivot(double[][] ab, int k, String[] labels){

        double largest = Math.abs(ab[k][k]);
        int largest_row = k;
        int largest_column = k;

        int size = MatrixUtilities.shape(ab).getValue0();

        for(int i = k; i < size; i++){

            for(int j = k; j < size; j++){

                double current = Math.abs(ab[i][j]);
                if(current > largest){

                    largest = current;
                    largest_row = i;
                    largest_column = j;
                }
            }
        }

        if(largest == 0){ throw new RuntimeException("EL SISTEMA NO TIENE UNICA SOLUCION"); }
        else{

            if(largest_row != k){

                MatrixUtilities.swapRow(ab, k, largest_row);
            }

            if(largest_column != k){

                MatrixUtilities.swapColumn(ab, k, largest_column);
                MatrixUtilities.swapLabels(labels, k, largest_column);
            }
        }
    }
}
