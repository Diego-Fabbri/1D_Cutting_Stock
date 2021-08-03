

package com.mycompany.d_cutting_stock;

import Utility.Data;
import ilog.concert.IloException;
//import ilog.concert.IloException;
//import ilog.cplex.IloCplex;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IloException {
        System.setOut(new PrintStream("1D_Cutting_Stock.log"));
        int I = Data.Number_Of_Items();// |I|
        int J = Data.Number_Of_Cutting_Patterns(); // |J|
        double[] d = Data.Demand();// d_i
        
        double L = Data.Stock_Length(); // L
        int[][] A = Data.A();// matrix of a_ij
//        Data.print(A);
        double[] l = Data.Lengths();// l_i
        double[] w = Data.Waste(A, l,L);//waste w_i
        Data.printWaste(w);

        CS_Model model = new CS_Model(I,J,d,L,A,l,w);
        model.solveModel();
    }

   
}
