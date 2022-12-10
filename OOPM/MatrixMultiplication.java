import java.util.*;

class MatrixMultiplication {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter Order of 1st Matrix: ");
      int m1=s.nextInt(), n1=s.nextInt(), matrix1[][]=new int[m1][n1];
      System.out.println("Enter Matrix: ");
      for (int i=0; i<m1; ++i) {
         for (int j=0; j<n1; ++j) matrix1[i][j]=s.nextInt();
      }
      System.out.print("\nEnter Order of 2nd Matrix: ");
      int m2=s.nextInt(), n2=s.nextInt(), matrix2[][]=new int[m2][n2];
      System.out.println("Enter Matrix: ");
      for (int i=0; i<m2; ++i) {
         for (int j=0; j<n2; ++j) matrix2[i][j]=s.nextInt();
      }
      if (n1!=m2) {
         System.out.print("Matrix Multiplication not possible!!");
         return;
      }
      int result[][]=new int[m1][n2];
      for (int i=0; i<m1; ++i) {
         for (int j=0; j<n2; ++j) {
            int sum=0, counter=0;
            while (counter<n1) {
               sum+=matrix1[i][counter]*matrix2[counter][j];
               counter++;
            }
            
            result[i][j]=sum;
         }
      }
      System.out.println("\nResult Matrix: ");
      for (int i=0; i<m1; ++i) {
         for (int j=0; j<n2; ++j) System.out.print(result[i][j]+" ");
         System.out.print("\n");
      }
   }
}
