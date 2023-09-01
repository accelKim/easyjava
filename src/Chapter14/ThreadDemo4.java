package Chapter14;

public class ThreadDemo4 {
  public static void main(String[] args) {
    new Thread() {
      public void run() {
        for (int i = 0; i < 5; i++) {
          System.out.println("안녕!");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
          }
        }
      }
    }.start();
  }
}


