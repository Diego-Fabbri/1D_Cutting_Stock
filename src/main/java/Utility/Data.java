package Utility;

public class Data {

    public static int Number_Of_Cutting_Patterns() { // |J|

        return 20;
    }

    public static int Number_Of_Items() { // |I|

        return 5;
    }

    public static double Stock_Length() { // |I|

        return 850;
    }

    public static double[] Demand() {//d_i
        double[] demand = {50, 30, 40,42, 20};
        return demand;
    }

    public static double[] Lengths() { //l_i
        double[] lengths = {330, 315, 295, 250, 205};
        return lengths;
    }

    public static int[][] A() { // matrix a_ij
        int[][] A = {
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 2, 0},
            {1, 0, 2, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 2, 0, 1, 0, 0, 1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 2, 0, 0, 2, 2, 0, 1, 1, 1, 3, 0, 0, 0, 2, 0, 1},
            {1, 0, 1, 1, 0, 4, 1, 0, 0, 1, 1, 1, 1, 0, 2, 2, 2, 1, 0, 2}

        };
        return A;
    }

    public static double[] Waste(int[][] A, double[] Lengths, double Stock_Length) {
        double[] waste = new double[A[0].length];

        for (int j = 0; j < A[0].length; j++) {
            double count = 0;
            for (int i = 0; i < A.length; i++) {
                count = count + A[i][j] * Lengths[i];
                waste[j] = Stock_Length - count;

            }
        }

        return waste;
    }

    public static void printWaste(double[] w) {
        System.out.println("Vector of waste associated to cutting patterns j :");

        for (int j = 0; j < w.length; j++) {

            System.out.print(" ---> Waste[" + (j + 1) + "] is : " + w[j]);
            System.out.println();
        }
             System.out.println();
    }
    


}
