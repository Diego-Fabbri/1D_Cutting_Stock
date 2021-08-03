package com.mycompany.d_cutting_stock;

import ilog.concert.IloException;
import ilog.concert.IloIntVar;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.concert.IloObjective;
import ilog.concert.IloObjectiveSense;
import ilog.cplex.IloCplex;


public class CS_Model {

    protected IloCplex model;
    protected int I;
    protected int J;
    protected double[] d;
    protected double L;

    protected int[][] A;
    protected double[] l;
    protected double[] w;

    protected IloIntVar[] x;//  vector of variables x_j

    CS_Model(int I, int J, double[] d, double L, int[][] A, double[] l, double[] w) throws IloException {
        this.model = new IloCplex();
        this.I = I;
        this.J = J;
        this.d = d;
        this.L = L;
        this.A = A;
        this.l = l;
        this.w = w;
        this.x = new IloIntVar[A[0].length];
    }

    protected void addVariables() throws IloException {

        for (int j = 0; j < J; j++) {
            int pos_j = j + 1;
            x[j] = (IloIntVar) model.numVar(0, Integer.MAX_VALUE, IloNumVarType.Int, "x[" + pos_j + "]");

        }
    }
    //The following code creates the objective function for the problem

    protected void addObjective() throws IloException {
        IloLinearNumExpr objective = model.linearNumExpr();

        for (int j = 0; j < J; j++) {

            objective.addTerm(x[j], 1);

        }

        IloObjective Obj = model.addObjective(IloObjectiveSense.Minimize, objective);
    }

    protected void addConstraints() throws IloException {

        for (int i = 0; i < I; i++) {
            IloLinearNumExpr expr = model.linearNumExpr();
            for (int j = 0; j < J; j++) {

                expr.addTerm(x[j], A[i][j]);
            }
            model.addGe(expr, d[i]);
        }

    }

    public void solveModel() throws IloException {
        addVariables();
        addObjective();
        addConstraints();
        model.exportModel("1D_Cutting_Stock_Model.lp");
        // model.setParam(IloCplex.Param.MIP.Tolerances.MIPGap,0.23);// max gap of 23%
        //model.setParam(IloCplex.Param.TimeLimit,600);// set a 600 seconds = 10 minutes time limit for solving
        model.solve();

        if (model.getStatus() == IloCplex.Status.Feasible
                | model.getStatus() == IloCplex.Status.Optimal) {
            System.out.println();
            System.out.println("Solution status = " + model.getStatus());
            System.out.println();
            double count =0;
             for (int i = 0; i < I; i++) {
                
                    count = count + d[i] * l[i];

                }
             System.out.println("Total length required by items' demand : " + count);
             System.out.println();
             count = Math.ceil(count/L);
             System.out.println("Minimum number of stock (continuous lower bound) : " + count);
             System.out.println();
            System.out.println("Total number of Stock used " + model.getObjValue());
            System.out.println();
            System.out.println("The variables x_{j} ");

            for (int j = 0; j < J; j++) {
                if (model.getValue(x[j]) != 0) {
                    System.out.println("---->" + x[j].getName() + " = " + model.getValue(x[j]));

                }
            }

            System.out.println();
            //calculate total waste
            double total_waste = L * model.getObjValue(); // initial value is Total length of stock used
            System.out.println("Total length of stock used = " + total_waste);

            for (int j = 0; j < J; j++) {
                total_waste = total_waste - model.getValue(x[j]) * w[j];

            }
            System.out.println();
            System.out.println("Total Length used for cut items is = " + total_waste);
            total_waste = L * model.getObjValue() - total_waste;
            System.out.println();
            System.out.println("Total waste is = " + total_waste);
            System.out.println();
            
            for (int i = 0; i < I; i++) {
                double counter = 0;
                for (int j = 0; j < J; j++) {
                    counter = counter + A[i][j] * model.getValue(x[j]);

                }

                System.out.println("---> Number of Items " + (i + 1) + " cut is " + counter + " out of a demand " + d[i]);
            }

        } else {
            System.out.println("The problem status is: " + model.getStatus());
        }

    }
}
