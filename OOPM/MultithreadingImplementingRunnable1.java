class ThreadA implements Runnable {
   public void run() {
      for (int i=0; i<=7; ++i) System.out.println(i);
   }
}

class ThreadB extends Thread {
   public void run() {
      System.out.println("Monday");
      System.out.println("Tuesday");
      System.out.println("Wednesday");
      System.out.println("Thursday");
      System.out.println("Friday");
      System.out.println("Saturday");
      System.out.println("Sunday");
   }
}

class MultithreadingImplementingRunnable1 {
   public static void main(String[] args) {
      ThreadA key0 = new ThreadA();
      Thread bake0 = new Thread(key0);
      bake0.start();
      ThreadB key1 = new ThreadB();
      Thread bake1 = new Thread(key1);
      bake1.start();
   }
}

// class MultithreadingImplementingRunnable1 {
//    public static void main(String[] args) {
//       ThreadA key0 = new ThreadA();
//       Thread bake0 = new Thread(key0);
//       ThreadB key1 = new ThreadB();
//       Thread bake1 = new Thread(key1);
//       bake0.start();
//       try {
//          bake0.join();
//       } catch(InterruptedException e) {
//          System.out.print(e);
//       }
//       bake1.start();
//       try {
//          bake1.join();
//       } catch(InterruptedException e) {
//          System.out.print(e);
//       }
//    }
// }
