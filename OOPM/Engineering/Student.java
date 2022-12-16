package Engineering;
import java.util.*;

public class Student {
   String studentName;
   int roll, year, subject1, subject2, subject3, subject4, totalMarks;
   double average;
   Scanner sc=new Scanner(System.in);
   public Student(int roll, String studentName, int year, int subject1, int subject2, int subject3, int subject4) {
      this.studentName=studentName;
      this.roll=roll;
      this.year=year;
      this.subject1=subject1;
      this.subject2=subject2;
      this.subject3=subject3;
      this.subject4=subject4;
      totalMarks=this.subject1+this.subject2+this.subject3+this.subject4;
      average=totalMarks/4;
   }
   public Student() {
      System.out.print("\nEnter Student Name: ");
      this.studentName=sc.next();
      System.out.print("Enter Student Roll Number: ");
      this.roll=sc.nextInt();
      System.out.print("Enter Expected Passing Year: ");
      this.year=sc.nextInt();
   }
   public void getMarks() {
      System.out.print("\nEnter Subject 1 Marks out of 100: ");
      subject1=sc.nextInt();
      System.out.print("Enter Subject 2 Marks out of 100: ");
      subject2=sc.nextInt();
      System.out.print("Enter Subject 3 Marks out of 100: ");
      subject3=sc.nextInt();
      System.out.print("Enter Subject 4 Marks out of 100: ");
      subject4=sc.nextInt();
      totalMarks=subject1+subject2+subject3+subject4;
      average=totalMarks/4;
   }
}

