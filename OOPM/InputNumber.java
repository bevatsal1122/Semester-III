import java.util.*;

class InputNumber {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("Enter Number: ");
      int i = s.nextInt();
      System.out.println("The Number is " + i + ".");
      s.close();
   }
}
