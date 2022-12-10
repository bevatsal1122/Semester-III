package myMath;

public class Power {
   public static int cal_pow(int a, int b) {
      int result=a, p=b;
      while (--p>0) result*=a;
      return result;
   }
}
