/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author ACER
 */
public class Manager {

   
   public static void menu(){
       System.out.println("--Calculator program--");
       System.out.println("1: add matrix");
       System.out.println("2: sub matrix");
       System.out.println("3: multi matrix");
       System.out.println("4: exit");
       
   }
   
   public static void inputValueMatrix(int[][] matrix, int id){
       int row = matrix.length;
       int col = matrix[0].length;
       for(int i=0; i<row;i++){
           for (int j = 0; j < col; j++) {
               matrix[i][j]= Validation.checkInt("Enter matrix "+id+" ["+i+"]"+"["+j+"]:", Integer.MIN_VALUE, Integer.MAX_VALUE);
           }
       }
       
   }
    
   public static void display(int[][] matrix, int id){
       int row = matrix.length;
       int col = matrix[0].length;
       System.out.println("Matrix "+id+":");
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               System.out.print(matrix[i][j]+ " " );
           }
           System.out.println("");
       }
       
   }
   
   public static void addMatrix(){
       System.out.println("--Addition--");
       int row = Validation.checkInt("Enter row of matrix: ", 1, Integer.MAX_VALUE);
       int col = Validation.checkInt("Enter col of matrix: ", 1, Integer.MAX_VALUE);
       int[][] matrix1 = new int[row][col];
       System.out.println("Matrix 1("+row+"x"+col+")");
       inputValueMatrix(matrix1, 1);
       
       int row2 = Validation.checkInt("Enter row matrix 2: ", row, row);
       int col2 = Validation.checkInt("Enter col matrix 2: ", col, col);
       int[][] matrix2 = new int[row2][col2];
       System.out.println("Matrix 2("+row2+"x"+col2+")");
       inputValueMatrix(matrix2, 2);
       
       int[][] mResult = new int[row][col];
       
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               mResult[i][j] = matrix1[i][j]+ matrix2[i][j];
           }
       }
       
       display(matrix1, 1);
       display(matrix2, 2);
       
       System.out.println("--Result--");
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               System.out.print("["+mResult[i][j]+"]");
           }
           System.out.println("");
       }
       
   }
   
    public static void subMatrix(){
       System.out.println("--submation--");
       int row = Validation.checkInt("Enter row of matrix: ", 1, Integer.MAX_VALUE);
       int col = Validation.checkInt("Enter col of matrix: ", 1, Integer.MAX_VALUE);
       int[][] matrix1 = new int[row][col];
       System.out.println("Matrix 1("+row+"x"+col+")");
       inputValueMatrix(matrix1, 1);
       
       int row2 = Validation.checkInt("Enter row matrix 2: ", row, row);
       int col2 = Validation.checkInt("Enter col matrix 2: ", col, col);
       int[][] matrix2 = new int[row2][col2];
       System.out.println("Matrix 2("+row2+"x"+col2+")");
       inputValueMatrix(matrix2, 2);
       
       int[][] mResult = new int[row][col];
       
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               mResult[i][j] = matrix1[i][j] - matrix2[i][j];
           }
       }
       
       display(matrix1, 1);
       display(matrix2, 2);
       
       System.out.println("--Result--");
       for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
               System.out.print("["+mResult[i][j]+"]");
           }
           System.out.println("");
       }
       
   }
   
     public static void Mutiplication(){ // hang m1 nhan col m2
         System.out.println("------------------Mutilication Matrix--------------");
        int rowMatrix1 = Validation.checkInt("Enter RowMatrix1: ", 1, Integer.MAX_VALUE);
        int colMatrix1 = Validation.checkInt("Enter Column Matrix1: ", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[rowMatrix1][colMatrix1];
        
        System.out.println("Matrix 1: (" + rowMatrix1 + "x" + colMatrix1 + ")");
        inputValueMatrix(matrix1, 1);
        
        int rowMatrix2 = Validation.checkInt("Enter RowMatrix2: ", colMatrix1, colMatrix1);
        int colMatrix2 = Validation.checkInt("Enter ColMatrix2: ", 1, Integer.MAX_VALUE);
        int [][] matrix2 = new int[rowMatrix2][colMatrix2];
        System.out.println("Matrix 2: ("+ rowMatrix2 + "x" + colMatrix2 + ")");
        inputValueMatrix(matrix2, 2);
        
        int [][] matrixResult = new int[rowMatrix1][colMatrix2];
             
        for (int i = 0; i < rowMatrix1; i++) {
            for (int j = 0; j < colMatrix2; j++) {
           int value = 0;
                for (int k = 0; k < colMatrix1; k++) {
                    value += matrix1[i][k] * matrix2[k][j];
                }
                matrixResult[i][j] =  value;
            }
        }
        
        display(matrix1, 1);
        display(matrix2, 2);
        System.out.println("===================Result=================");
        for (int i = 0; i < rowMatrix1; i++) {
            for (int j = 0; j < colMatrix2; j++) {
                System.out.print("[" + matrixResult[i][j] + "]");
            }
            System.out.println();
        }
    }
}
