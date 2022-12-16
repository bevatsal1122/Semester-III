import java.util.*;

class JaggedArrays3D {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      char data[][][]=new char [2][][];
      data[0]=new char[3][];
      data[0][0]=new char[4]; 
      data[0][1]=new char[3]; 
      data[0][2]=new char[2]; 
      data[1]=new char[2][];
      data[1][0]=new char[3]; 
      data[1][1]=new char[4]; 
      for (int i=0; i<2; ++i) {
         for (int j=0; j<data[i].length; ++j) {
            for (int k=0; k<data[i][j].length; ++k) {
               data[i][j][k]='*';
            }
         }
      }

      System.out.println();
      for (int i=0; i<2; ++i) {
         for (int j=0; j<data[i].length; ++j) {
            for (int k=0; k<data[i][j].length; ++k) System.out.print(data[i][j][k]+" ");
            System.out.println();
         }
         System.out.println();
      }
      s.close();

   }
}
