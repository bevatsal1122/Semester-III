import java.util.*;

class ThreadA implements Runnable {
   synchronized public void run() {
      while(true) {
         Random rand = new Random();
         int number = rand.nextInt(201);
         System.out.println("Random Integer: "+number);
         if (number%2==0) {
            ThreadB key1 = new ThreadB(number);
            Thread bake1 = new Thread(key1);
            bake1.start();
         }
         else {
            ThreadC key2 = new ThreadC(number);
            Thread bake2 = new Thread(key2);
            bake2.start();
         }
         try {
            Thread.sleep(1000);
         } catch(Exception e) {
            System.out.println(e);
         }
      }
   }
}

class ThreadB implements Runnable {
   int number;
   ThreadB(int number) {
      this.number=number;
   }
   synchronized public void run() {
      System.out.println("Even Number");
      System.out.println("Square: "+number*number+"\n");
   }
}

class ThreadC implements Runnable {
   int number;
   ThreadC(int number) {
      this.number=number;
   }
   synchronized public void run() {
      System.out.println("Odd Number");
      System.out.println("Cube: "+(int)Math.pow(number, 3)+"\n");
   }
}

class Question8 {
   public static void main(String[] args) {
         ThreadA key0 = new ThreadA();
         Thread bake0 = new Thread(key0);
         System.out.print("\nRandom Integers Range: [0, 200]\n\n");
         bake0.start();
   }
}
