public class NoVisibility
{
  private volatile static boolean ready;
  private static int number;

  private static class ReaderThread extends Thread {
    public void run() {
      while (!ready) {
        System.out.println("ready is false");
        Thread.yield();
      }
      System.out.println(number);
    }
  }

  public static void main(String args[]) {
    new ReaderThread().start();
    System.out.println("wait");
    number = 42;
    ready = true;
  }
}
