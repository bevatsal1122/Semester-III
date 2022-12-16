// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;

class AllOperations {
   int a, b, c, d;
   AllOperations(int a, int b, int c, int d) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
   }
   public String add() {
      String result="("+Integer.toString(a+c)+") + ("+Integer.toString(b+d)+")i";
      return result;
   }
   public String subtract() {
      String result="("+Integer.toString(a-c)+") + ("+ Integer.toString(b-d)+")i";
      return result;
   }
   public String multiply() {
      String result="("+Integer.toString((a*c)+((b*d)*(-1)))+") + ("+Integer.toString((b*c)+(a*d))+")i";
      return result;
   }
   public String divide() {
      float denominator=c*c+d*d;
      String result="("+Float.toString(((a*c)+(b*d))/denominator)+") + ("+Float.toString(((b*c)+((a*d)*(-1)))/denominator)+")i";
      return result;
   }
}

class Question1 {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("\nOptions -\nEnter 1 for Addition\nEnter 2 for Subtraction\nEnter 3 for Multiplication\nEnter 4 for Division");
      System.out.print("\nEnter Choice: "); int choice=s.nextInt();
      if (choice>=5 || choice<=0) {
         System.out.println("Out of Range Option!!"); 
         s.close(); 
         return;
      }
      System.out.print("\nComplex Number 1: a + bi");
      System.out.print("\nEnter a: "); int a=s.nextInt();
      System.out.print("Enter b: "); int b=s.nextInt();
      System.out.print("\nComplex Number 2: c + di");
      System.out.print("\nEnter c: "); int c=s.nextInt();
      System.out.print("Enter d: "); int d=s.nextInt();
      AllOperations op = new AllOperations(a, b, c, d);
      if (choice==1) {
         System.out.println("\nOperation: [("+a+")+("+b+")i] + "+"[("+c+")+("+d+")i]");
         System.out.println("Final Answer: "+op.add());
      }
      else if (choice==2) {
         System.out.println("\nOperation: [("+a+")+("+b+")i] - "+"[("+c+")+("+d+")i]");
         System.out.println("Final Answer: "+op.subtract());
      }
      else if (choice==3) {
         System.out.println("\nOperation: [("+a+")+("+b+")i] * "+"[("+c+")+("+d+")i]");
         System.out.println("Final Answer: "+op.multiply());
      }
      else if (choice==4) {
         System.out.println("\nOperation: [("+a+")+("+b+")i] / "+"[("+c+")+("+d+")i]");
         System.out.println("Final Answer: "+op.divide());
      }
      s.close();
   }
}


// import java.util.*;

// class AllOperations {
//    public static String add(int a, int b, int c, int d) {
//       String result="("+Integer.toString(a+c)+") + ("+Integer.toString(b+d)+")i";
//       return result;
//    }
//    public static String subtract(int a, int b, int c, int d) {
//       String result="("+Integer.toString(a-c)+") + ("+ Integer.toString(b-d)+")i";
//       return result;
//    }
//    public static String multiply(int a, int b, int c, int d) {
//       String result="("+Integer.toString((a*c)+((b*d)*(-1)))+") + ("+Integer.toString((b*c)+(a*d))+")i";
//       return result;
//    }
//    public static String divide(int a, int b, int c, int d) {
//       float denominator=c*c+d*d;
//       String result="("+Float.toString(((a*c)+((b*d)))/denominator)+") + ("+Float.toString(((b*c)+((a*d)*(-1)))/denominator)+")i";
//       return result;
//    }
// }

// class Question1 {
//    public static void main(String[] args) {
//       Scanner s=new Scanner(System.in);
//       System.out.println("\nOptions -\nEnter 1 for Addition\nEnter 2 for Subtraction\nEnter 3 for Multiplication\nEnter 4 for Division");
//       System.out.print("\nEnter Choice: "); int choice=s.nextInt();
//       if (choice>=5 || choice<=0) {
//          System.out.println("Out of Range Option!!");  
//          return;
//       }
//       System.out.print("\nComplex Number 1: a + bi");
//       System.out.print("\nEnter a: "); int a=s.nextInt();
//       System.out.print("Enter b: "); int b=s.nextInt();
//       System.out.print("\nComplex Number 2: c + di");
//       System.out.print("\nEnter c: "); int c=s.nextInt();
//       System.out.print("Enter d: "); int d=s.nextInt();
//       if (choice==1) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] + "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+AllOperations.add(a, b, c, d));
//       }
//       else if (choice==2) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] - "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+AllOperations.subtract(a, b, c, d));
//       }
//       else if (choice==3) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] * "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+AllOperations.multiply(a, b, c, d));
//       }
//       else if (choice==4) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] / "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+AllOperations.divide(a, b, c, d));
//       }
//       s.close();
//    }
// }


// import java.util.*;

// class Question1 {
//    public static String add(int a, int b, int c, int d) {
//       String result="("+Integer.toString(a+c)+") + ("+Integer.toString(b+d)+")i";
//       return result;
//    }
//    public static String subtract(int a, int b, int c, int d) {
//       String result="("+Integer.toString(a-c)+") + ("+ Integer.toString(b-d)+")i";
//       return result;
//    }
//    public static String multiply(int a, int b, int c, int d) {
//       String result="("+Integer.toString((a*c)+((b*d)*(-1)))+") + ("+Integer.toString((b*c)+(a*d))+")i";
//       return result;
//    }
//    public static String divide(int a, int b, int c, int d) {
//       float denominator=c*c+d*d;
//       String result="("+Float.toString(((a*c)+((b*d)))/denominator)+") + ("+Float.toString(((b*c)+((a*d)*(-1)))/denominator)+")i";
//       return result;
//    }
//    public static void main(String[] args) {
//       Scanner s=new Scanner(System.in);
//       System.out.println("\nOptions -\nEnter 1 for Addition\nEnter 2 for Subtraction\nEnter 3 for Multiplication\nEnter 4 for Division");
//       System.out.print("\nEnter Choice: "); int choice=s.nextInt();
//       if (choice>=5 || choice<=0) {
//          System.out.println("Out of Range Option!!");  
//          return;
//       }
//       System.out.print("\nComplex Number 1: a + bi");
//       System.out.print("\nEnter a: "); int a=s.nextInt();
//       System.out.print("Enter b: "); int b=s.nextInt();
//       System.out.print("\nComplex Number 2: c + di");
//       System.out.print("\nEnter c: "); int c=s.nextInt();
//       System.out.print("Enter d: "); int d=s.nextInt();
//       if (choice==1) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] + "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+add(a, b, c, d));
//       }
//       else if (choice==2) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] - "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+subtract(a, b, c, d));
//       }
//       else if (choice==3) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] * "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+multiply(a, b, c, d));
//       }
//       else if (choice==4) {
//          System.out.println("\nOperation: [("+a+")+("+b+")i] / "+"[("+c+")+("+d+")i]");
//          System.out.println("Final Answer: "+divide(a, b, c, d));
//       }
//    }
// }
