import java.util.Scanner;

public class Execrise6 {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the number of rows : ");
       int rows = scanner.nextInt();
       System.out.print("Enter the number of columns : ");
       int cols = scanner.nextInt();
       int[][] matrixA=new int[rows][cols];
       int[][] matrixB=new int[rows][cols];
       int[][] sumMatrix=new int[rows][cols];
       System.out.println("Enter the elements of Matrix A:");
       for(int i=0; i<rows; i++) {
          for(int j=0; j<cols; j++) {
            System.out.print("Enter element A["+(i+1) + "]["+(j+1) +"]: ");
             matrixA[i][j] = scanner.nextInt();
          }
       } 
       System.out.println("Enter the elements of Matrix B:");
       for(int i=0; i<rows; i++) {
         for(int j=0; j<cols; j++) {
            System.out.print("Enter element B["+(i+1) + "]["+(j+1) +"]: ");
             matrixB[i][j] = scanner.nextInt();
          }
        }
        for(int i=0; i<rows; i++) {
          for(int j=0; j<cols; j++) {
             sumMatrix[i][j] =matrixA[i][j] + matrixB[i][j];
          }
        }
        System.out.println("Sum of Matrix A and B:");
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println();
        } 
    }
}
