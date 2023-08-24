package Chapter11;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueDemo {
  public static void main(String[] args) throws NoSuchElementException {
    Queue<String> q = new LinkedList<>();
    q.offer("바나나");
    q.offer("사과");
    q.offer("배");
    System.out.println(q.peek());
    while (!q.isEmpty()) {
      System.out.println(q.poll() + "가 삭제되었습니다");
    }
    System.out.println(q.peek());
    q.poll();
  }
}
