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

class SeriesSineAndCosine {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("\nThe Series for Sine & Cosine only works for Smaller Value of x (Radians), particulary for less than 90°.");
      System.out.print("\nEnter Value in Degrees: "); int d=s.nextInt();
      double x=d*Math.PI/180;
      System.out.println("x = " + x);

      System.out.println("\nsinx(x) = x - ((x^3)/3!) + ((x^5)/5!) - ((x^7)/7!) + ... (Upto n times)");
      System.out.println("cos(x) = 1 - ((x^2)/2!) + ((x^4)/4!) - ((x^6)/6!) + ... (Upto n times)");
      System.out.println("The Value of n should be atleast greater than 5 for Correct Evaluation.");

      System.out.print("\nEnter Value of n: "); int n=s.nextInt();

      double cosx=0, sinx=0;
      int cosCounter=0, sinCounter=1;
      for (int i=0; i<n; ++i, cosCounter+=2, sinCounter+=2) {
         sinx+=MyMath.power(-1, i)*MyMath.power(x, sinCounter)/MyMath.fact(sinCounter);
         cosx+=MyMath.power(-1, i)*MyMath.power(x, cosCounter)/MyMath.fact(cosCounter);
      }

      double sinValue=(double)(Math.round(sinx*10000))/10000, cosValue=(double)Math.round(cosx*10000)/10000;
      System.out.println("\nsin(" + d + "°) = sin(" + x + "rad) ≈ " + sinValue);
      System.out.println("cos(" + d + "°) = cos(" + x + "rad) ≈ " + cosValue);
      s.close();
   }
}
