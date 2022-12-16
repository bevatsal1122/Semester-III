import java.util.*;

abstract class SalaryAccount {
   abstract void bank_name();
   void employee_status() { 
      System.out.println("Employee Status: Ongoing Agreement !! (Inside Class SalaryAccount)");
   }
}

class Employee1 extends SalaryAccount {
   Employee1() { }
   Employee1(int ID, String name) { }
   Employee1(int ID, double salary, String name) { }

   // Overriding bank_name() & employee_status()
   void bank_name() {
      System.out.println("Welcome to KJSCE Bank !! (Inside Class Employee1)");
   }
   void employee_status() { 
      System.out.println("Employee Status: Ongoing Agreement !! (Inside Class Employee1)");
   }
}

class Employee2 extends SalaryAccount {
   int ID;
   double salary;
   String name;

   Employee2(int ID, double salary, String name) {
      this.ID = ID;
      this.salary = salary;
      this.name = name;
   }

   // Overriding bank_name() & employee_status()
   void bank_name() { 
      System.out.println("Welcome to KJSCE Bank !! (Inside Class Employee2)");
   }
   void employee_status() { 
      System.out.println("Employee Status: Ongoing Agreement (Indside Class Employee2)");
      System.out.println("ID: " + ID + "\tSalary: " + salary + "\tName: " + name);
   }
}

class HierarchicalInheritance {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.println("\nHello Vatsal\n");
      SalaryAccount Employee1 = new Employee1();
      Employee1.bank_name();
      Employee1.employee_status();
      System.out.println();
      SalaryAccount Employee2 = new Employee2(15, 888880, "Vatsal");
      Employee2.bank_name();
      Employee2.employee_status();
      System.out.println();
      s.close();
   }
}
