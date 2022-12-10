import java.util.*;

class TimeException extends Exception {
   int h0, h1, m0, s0, m1, s1;
   TimeException(int h0, int h1, int m0, int s0, int m1, int s1) {
      this.h0=h0;
      this.h1=h1;
      this.m0=m0;
      this.s0=s0;
      this.m1=m1;
      this.s1=s1;
   }

   public String LimitException() {
      return ("\nLimitException: Time in Seconds or Minutes excedeed Maximum Limit of 60.\nHence, formated & added the overlapping units.");
   }
}

class ExceptionHandlingTimeException {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);   
      System.out.print("\nEnter Time 1 (HH MM SS): ");
      int h0=s.nextInt();
      int m0=s.nextInt();
      int s0=s.nextInt();
      System.out.print("\nEnter Time 2 (HH MM SS): ");
      int h1=s.nextInt();
      int m1=s.nextInt();
      int s1=s.nextInt();
      int totalH=h0+h1, totalM=m0+m1, totalS=s0+s1;
      TimeException a=new TimeException(h0, h1, m0, s0, m1, s1);
      try {
         int key=0;
         if (totalS>60) {
            totalM+=(int)(totalS/60);
            totalS=totalS%60;
            key=1;
         }
         if (totalM>60) {
            totalH+=(int)(totalM/60);
            totalM=totalM%60;
            key=1;
         }
         if (key==1) throw a;
      } catch (TimeException e) {
         System.out.println(e.LimitException());
      }      
      System.out.println("\nTotal Time (HH MM SS): "+totalH+":"+totalM+":"+totalS);
   }
}
