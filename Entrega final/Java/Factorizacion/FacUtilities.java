package me.DavidLake.AnalisisNumerico.Factorizacion;

import me.DavidLake.AnalisisNumerico.MatrixUtilities;
import me.DavidLake.AnalisisNumerico.ProgressiveSubstitution;
import me.DavidLake.AnalisisNumerico.RegressiveSubstitution;
import org.javatuples.Pair;
import org.javatuples.Triplet;

public class FacUtilities {

    public static double[] solve_simple_gaussian_fac(double[][] a, double[] b){

        double[][] lower_tri = LU_Gauss.solve(a);
        double[] z = ProgressiveSubstitution.solve(MatrixUtilities.to_aug(lower_tri, b));

        return RegressiveSubstitution.solve(MatrixUtilities.to_aug(a, z));
    }

    public static Pair<double[], Double> solve_lu_fac_with_parvial_pivot(double[][] a, double[] b){

        Triplet<double[][], double[][], Double> res = LU_Partial_Pivot.solve(a);
        double[][] lower_tri = res.getValue0();
        double[][] permutation = res.getValue1();
        double q = res.getValue2();

        double[] pb = MatrixUtilities.dot(permutation, b);
        double[] z = ProgressiveSubstitution.solve(MatrixUtilities.to_aug(lower_tri, pb));
        double[] x = RegressiveSubstitution.solve(MatrixUtilities.to_aug(a, z));

        return new Pair<>(x, q);
    }

    public static double[] solve_cholesky_fac(double[][] a, double[] b){

        double[][] lower_tri = Cholesky.solve(a).getValue0();
        double[][] upper_tri = Cholesky.solve(a).getValue1();

        double[] z = ProgressiveSubstitution.solve(MatrixUtilities.to_aug(lower_tri, b));

        return RegressiveSubstitution.solve(MatrixUtilities.to_aug(upper_tri, z));
    }

    public static double[] solve_crout_fac(double[][] a, double[] b){

        double[][] lower_tri = Crout.solve(a).getValue0();
        double[][] upper_tri = Crout.solve(a).getValue1();

        double[] z = ProgressiveSubstitution.solve(MatrixUtilities.to_aug(lower_tri, b));

        return RegressiveSubstitution.solve(MatrixUtilities.to_aug(upper_tri, z));
    }

    public static double[] solve_dolittle_fac(double[][] a, double[] b){

        double[][] lower_tri = Dolittle.solve(a).getValue0();
        double[][] upper_tri = Dolittle.solve(a).getValue1();

        double[] z = ProgressiveSubstitution.solve(MatrixUtilities.to_aug(lower_tri, b));

        return RegressiveSubstitution.solve(MatrixUtilities.to_aug(upper_tri, z));
    }
}
