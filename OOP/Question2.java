import java.util.*;

class MyMath {
   public static double power(double x, int y) {
      double result=1;
      for (int i=1; i<=y; ++i) result*=x;
      return result;
   }

   public static int fact(int x) {
      int result=1;
      for (int i=x; i>=2; --i) result*=i;
      return result;
   }
}

class Question2 {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter Value of x: "); double x=s.nextInt();
      System.out.print("Enter Value of n: "); int n=s.nextInt();
      System.out.println("\nx = " + x);
      System.out.println("n = " + n);

      double cosx=0, sinx=0, ex=0, xn=0;
      for (int i=0; i<n; ++i) {
         ex+=MyMath.power(x, i)/MyMath.fact(i);
         int multiplyn=1;
         if (i>=1) {
            for (int j=0; j<i; ++j) {
               multiplyn*=(n-j);
            }
         }
         xn+=(multiplyn*MyMath.power(x, i))/MyMath.fact(i);
      }

      System.out.println("\ne^" + x + " ≈ " + ex);
      System.out.println("(1 + " + x + ")^" + n + " ≈ " + xn);
   }
}
