// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;

class MathOperation
{
	public static double findMedian(int a[], int n)
	{
		Arrays.sort(a);
		System.out.print("\nSorted List: ");
		for (int i=0; i<n; ++i) {
      	if (i<n-1) System.out.print(a[i]+", ");
			else System.out.print(a[i]);
		}
		if (n%2!=0) return a[n/2];
		return (double)((a[(n-1)/2]+a[n/2])/2.0);
	}
}

class FindMedian {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);
      System.out.print("\nEnter Length: "); int n=s.nextInt();
		if (n<=0) {
			System.out.print("Wrong Input!!");
			return;
		}
		int a[]=new int [n];
		for (int i=0; i<n; ++i) {
      	System.out.print("Enter Element " + (int)(i+1) + ": "); int t=s.nextInt();
			a[i]=t;
		}
	
		System.out.print("\n\nMedian: " + MathOperation.findMedian(a, n) + "\n");
   }
}
