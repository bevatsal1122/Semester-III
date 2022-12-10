import java.util.*;

class Account {
   int accountID;
   String name;
   double balance;
   Account(int accountID, String name, double balance) {
      this.accountID=accountID;
      this.name=name;
      this.balance=balance;
   } 
   void printAccountData() {
      System.out.println("\nAccount ID: "+this.accountID);
      System.out.println("Account Holder Name: "+this.name);
      System.out.println("Account Balance: "+this.balance+" INR");
   }
}

class Question4 {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.print("\nEnter No. of Customers: ");
      int n=s.nextInt(), key=-1, lastID=0;
      if (n==0) {
         System.out.print("No Customers...\n");
         return;
      }
      Account data[]=new Account[n];
      System.out.print("\nOptions- \n1. Add Account\n2. Delete Account\n3. Display Account Details\n4. Exit\n\nChoice: ");
      int choice=s.nextInt();
      while(choice!=4) {
         if (choice==1) {
            key++;
            lastID++;
            if (key>=n) {
               System.out.print("\nMaximum Account Numbers Limit Reached!!\n");
            }
            else {
               System.out.print("Adding Account to Database...\n");
               System.out.print("\nCustomer "+(int)(key+1)+" (Account ID V-"+lastID+")");
               System.out.print("\nEnter Customer Name: ");
               String customerName=s.next();
               System.out.print("\nEnter Account Balance: ");
               double balance=s.nextDouble();
               data[key]=new Account(lastID, customerName, balance);
               System.out.print("Account added to Database...\n");
            }
         }
         else if (choice==2) {
            System.out.print("Deleting Account from Database...\n");
            System.out.print("\nEnter Account ID for Deletion: ");
            int deleteID=s.nextInt();
            deleteID--;
            if (deleteID<0 || deleteID>key) {
               System.out.print("\nWrong Account ID!!\n");
            }
            else {
               for (int i=deleteID; i<key; i++) {
                data[i]=data[i+1];
               }
               key--;
               System.out.print("Account deleted from Database...\n");
            }
         }
         else if (choice==3) {
            System.out.print("Fetching Account Details from Database...\n\n");
            if (key==-1) System.out.print("No Account Found in Database...\n");
            for (int i=0; i<=key; ++i) data[i].printAccountData();
         }
         else {
            System.out.print("Wrong Choice Entered!!\n");
         }
         System.out.print("\nOptions- \n1. Add Account\n2. Delete Account\n3. Display Account Details\n4. Exit\n\nChoice: ");
         choice=s.nextInt();
      }
      System.out.print("\nExiting...\n");
   }
}
