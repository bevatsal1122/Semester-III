import java.util.*;

class GeneratePythogorianTriplets {
   public static void main(String[] args) {

      Scanner s = new Scanner(System.in);
      System.out.println("How many Pythagorian Triplets do you want ??");
      int n = s.nextInt(), counter=0;
      for (int i=1; counter<n; i++)
      {
         for (int j=1; j<i; j++)
         {
            for (int k=j+1; k<i; k++)
            {
               if((k*k)+(j*j)==(i*i))
               {
                  System.out.println(j + " " +  k + " " + i);
                  counter++;
               }
            }
         }
      }
      s.close();
   }
}
