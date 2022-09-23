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
      int n=s.nextInt(), key=-1;
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
            if (key>=n) {
               System.out.print("Maximum Account Numbers Limit Reached");
            }
            System.out.print("Adding Account to Database...\n");
            int accountID=(key+1);
            System.out.print("\nCustomer "+(int)(key+1)+" (Account ID V-"+accountID+")");
            System.out.print("\nEnter Customer Name: ");
            String customerName=s.next();
            System.out.print("\nEnter Account Balance: ");
            double balance=s.nextDouble();
            data[key]=new Account(accountID, customerName, balance);
            System.out.print("Account added to Database...\n");
         }
         else if (choice==2) {
            System.out.print("Deleting Account from Database...\n");
            System.out.print("\nEnter Accound ID for Deletion: ");
            int deleteID=s.nextInt();
            deleteID--;
            if (deleteID<0 || deleteID>key) {
               System.out.print("Wrong Account ID!!\n");
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
            if (key==-1) {
               System.out.print("No Account Found in Database...\n");
            }
            for (int i=0; i<=key; ++i) {
               System.out.println("Customer "+(int)(i+1)+" Data");
               data[i].printAccountData();
            }
         }
         else {
            System.out.print("Wrong Choice Entered!!\n");
         }
         System.out.print("\nOptions- \n1. Add Account\n2. Delete Account\n3. Display Account Details\n4. Exit\n\nChoice: ");
         choice=s.nextInt();
      }
      System.out.print("Exiting...\n");
   }
}
