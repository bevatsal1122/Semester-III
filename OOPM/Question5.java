import java.util.*;

class Employee {
   String EName;
   int EID, ESalary;
   Employee(String name, int ID, int salary) {
      EName=name;
      EID=ID;
      ESalary=salary;
   }
   public void display() {
      System.out.println("\nEmployee ID: "+EID+"\nEmployee Name: "+EName+"\nSalary: "+ESalary);
   }
}

class Question5 {

   static Scanner sc=new Scanner(System.in);

   public static int findIndex(Vector<Employee> e, Employee target) {
      int key=0;
      for (int i=0; i<e.size(); ++i, ++key) {
         if (target.ESalary>e.get(i).ESalary) return key;
      }
      return key;
   }

   public static int hasEbyID(Vector<Employee> e, int ID) {
      for (int i=0; i<e.size(); ++i) {
         if (ID==e.get(i).EID) return i;
      }
      return -1;
   }

   public static int hasEbyName(Vector<Employee> e, String name) {
      for (int i=0; i<e.size(); ++i) {
         if (name.equals(e.get(i).EName)) return i;
      }
      return -1;
   }

   public static void insertData(Vector<Employee> employees) {
      System.out.print("Enter Employee ID: ");
      int id=sc.nextInt();
      while (hasEbyID(employees, id)!=-1) {
         System.out.print("Employee with enetered ID already exists...\nEnter Employee ID: ");
         id=sc.nextInt();
      }
      System.out.print("Enter Employee Name: ");
      String name=sc.next();
      System.out.print("Enter Salary: ");
      int salary=sc.nextInt();
      Employee one=new Employee(name, id, salary);
      int targetPosition=findIndex(employees, one);
      if (targetPosition==employees.size()) employees.addElement(one);
      else employees.insertElementAt(one, targetPosition);
   }

   public static void main(String[] args) {
      System.out.print("\nEnter No. of Employees: ");
      int n=sc.nextInt();
      while (n<=0) {
         System.out.print("Enter No. of Employees: ");
         n=sc.nextInt();
      }
      Vector<Employee> employees=new Vector<Employee>(n, 5);
      System.out.print("\nOptions -\n1. Create Employee Record\n2. Insert Employee Data\n3. Delete Employee Data by Name\n4. Delete Employee Data by ID\n5. Display Employees Data\n6. Exit\n\nEnter Choice: ");
      int choice=sc.nextInt();
      while (choice!=6) {
         if (choice==1) {
            System.out.print("\nEnter N: ");
            int N=sc.nextInt(), i=0;
            while ((N--)>0) {
               ++i;
               System.out.println("\nEmployee "+i+" Details");
               insertData(employees);
            }
            if (employees.size()!=0) System.out.println("\nEmployee Record Created Successfully!!");
         }
         else if (choice==2) {
            if (employees.size()==0) System.out.println("\nNo/Invalid/Empty Record found...\nFirst create a Valid Record!!");
            else {
               insertData(employees);
               System.out.println("Employee Data Successfully added...");
            }
         }
         else if (choice==3) {
            if (employees.size()==0) System.out.println("\nNo/Invalid/Empty Record found...\nFirst create a Valid Record!!");
            else {
               System.out.print("\nEnter Employee Name: ");
               String name=sc.next();
               int targetPosition=hasEbyName(employees, name);
               if (targetPosition!=-1) {
                  employees.remove(targetPosition);
                  System.out.println("Employee Data Successfully deleted...");
               }
               else System.out.print("Employee with given Name does not exist...\n");
            }
         }
         else if (choice==4) {
            if (employees.size()==0) System.out.println("\nNo/Invalid/Empty Record found...\nFirst create a Valid Record!!");
            else {
               System.out.print("\nEnter Employee ID: ");
               int id=sc.nextInt();
               int targetPosition=hasEbyID(employees, id);
               if (targetPosition!=-1) {
                  employees.remove(targetPosition);
                  System.out.println("Employee Data Successfully deleted...");
               }
               else System.out.print("Employee with given ID does not exist...\n");
            }
         }
         else if (choice==5) {
            if (employees.size()==0) System.out.println("\nNo/Invalid/Empty Record found...\nFirst create a Valid Record!!");
            else {
               for (int i=0; i<employees.size(); ++i) {
                  employees.get(i).display();
               }
            }
         }
         else System.out.println("\nWrong Option!!");
         System.out.print("\nOptions -\n1. Create Employee Record\n2. Insert Employee Data\n3. Delete Employee Data by Name\n4. Delete Employee Data by ID\n5. Display Employees Data\n6. Exit\n\nEnter Choice: ");
         choice=sc.nextInt();
      }
      System.out.println("\nExiting...");
      sc.close();
   }
}
