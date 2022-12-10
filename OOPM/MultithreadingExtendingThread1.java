class ThreadA extends Thread {
      public void run() {
         char[] hello = new char[25];
         for (int i=65; i<90; ++i) hello[i-65]=(char)(i);
         for (int i=0; i<25; ++i) System.out.println(hello[i]);
      }
}

class ThreadB extends Thread {
      public void run() {
         for (int i=0; i<15; ++i) System.out.println("Hello World "+i);
      }
}
class MultithreadingExtendingThread1 {
      public static void main(String[] args) {
            ThreadA key0 = new ThreadA();
            ThreadB key1 = new ThreadB();
            key0.start();
            key1.start();
            System.out.println("key0 Priority: "+key0.getPriority());
            System.out.println("key1 Priority: "+key1.getPriority());
      }
}