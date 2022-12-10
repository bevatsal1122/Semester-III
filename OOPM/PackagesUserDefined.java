import java.util.*;
import firstPackage.A;
import myMath.*;

class PackagesUserDefined {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);   
      System.out.println(Factorial.fact(8));
      System.out.println(Power.cal_pow(8, 2));
   }
}

// class PackagesUserDefined {
//    public static void main(String[] args) {
//       Scanner s=new Scanner(System.in);   
//       A hello = new A();
//       hello.display();
//    }
// }
