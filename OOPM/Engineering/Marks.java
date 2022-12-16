package Engineering;
import java.util.*;

public class Marks {
   public static void sort(Vector<Student> s) {
      for (int i=0; i<s.size()-1; ++i) {
         for (int j=0; j<s.size()-i-1; ++j) {
            if (s.get(j).average>s.get(j+1).average) {
               Engineering.Student newStudent=new Engineering.Student(s.get(j).roll, s.get(j).studentName, s.get(j).year, s.get(j).subject1, s.get(j).subject2, s.get(j).subject3, s.get(j).subject4);
               s.set(j, s.get(j+1));
               s.set(j+1, newStudent);
            }
         }
      }
   }

   public static void display(Vector<Student> s) {
      for (int i=0; i<s.size(); ++i) {
         System.out.println(s.get(i).roll+"  "+s.get(i).studentName+"  "+s.get(i).year);
         System.out.println(s.get(i).subject1+"  "+s.get(i).subject2+"  "+s.get(i).subject3+"  "+s.get(i).subject4);
         System.out.println("Grand Total: "+s.get(i).totalMarks+"\nAverage Marks: "+s.get(i).average);
      }
   }
}