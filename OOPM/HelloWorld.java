// class HelloWorld {
//    public static void main(String[] args) {
//       System.out.println("Hello World");
//    }
// }

class HelloWorld {
   public static void main(String[] args) {
      System.out.println("Hello World");
      for (int i=0; i<args.length; ++i) {
         System.out.println("You entered " + args[i]);
      }
   }
}
