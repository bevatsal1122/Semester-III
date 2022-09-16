// Code by bevatsal1122
// Trust God, You Code Will Work

import java.util.*;

class Operations {
   public static double findCircumference(double r) {
      double circumference=2*r*Math.PI;
      return circumference;
   }
   public static double findArea(double r) {
      double area=Math.PI*Math.pow(r, 2);
      return area;
   }
}

class CircleCircumferenceAndArea {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("\nOptions -\nEnter 1 for finding Circumference of Circle\nEnter 2 for finding Area of Circle");
      System.out.print("\nEnter Choice: "); int choice=s.nextInt();
      if (choice!=1 && choice!=2) {
         System.out.println("Out of Range Option!!");
         return;
      }
      System.out.print("\nEnter Radius r: "); double radius=s.nextDouble();
      if (choice==1) {
         System.out.println("\nCircumference: "+Operations.findCircumference(radius)+" Units");
      }
      else if (choice==2) {
         System.out.println("\nArea: "+Operations.findArea(radius)+" Units");
      }
   }
}

