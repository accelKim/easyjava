package Chapter14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
  public static void main(String[] args) {
    Runnable task = () -> {
        for (int i = 0; i < 5; i++) {
          System.out.println("안녕!");
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
          }
        }
      };
    ExecutorService ex = Executors.newCachedThreadPool();
    ex.submit(task);

    for (int i = 0; i < 5; i++) {
      System.out.println("메인입니다");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }

//    ex.shutdown();
  }

  }



