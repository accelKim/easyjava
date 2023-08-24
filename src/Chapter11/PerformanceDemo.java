package Chapter11;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceDemo {
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();
    LinkedList<Integer> ll = new LinkedList<>();

    long start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.add(i);
    }
    long end = System.nanoTime();
    long arraylist = end - start;
    System.out.println(arraylist);


    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.add(0, i);
    }
    end = System.nanoTime();
    arraylist = end - start;
    System.out.println(arraylist);

    //arraylist 삭제 -맨뒤에서 삭제
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.remove(al.size() - 1);
    }
    end = System.nanoTime();
    arraylist = end - start;
    System.out.println(arraylist + "맨뒤에서 삭제");
    //arraylist 삭제 -맨앞에서 삭제
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.remove(0);
    }
    end = System.nanoTime();
    arraylist = end - start;
    System.out.println(arraylist + "맨앞에서 삭제");



    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.add(i);
    }
    end = System.nanoTime();
    long linkedlist = end - start;
    System.out.println(linkedlist);


    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.add(0,i);
    }
    end = System.nanoTime();
    linkedlist = end - start;
    System.out.println(linkedlist);
    //linkedList - 맨앞에서 삭제

    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.removeFirst();
    }
    end = System.nanoTime();
    linkedlist = end - start;
    System.out.println(linkedlist + "맨앞에서 삭제");

    //linkedList - 맨뒤에서 삭제
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.removeLast();
    }
    end = System.nanoTime();
    linkedlist = end - start;
    System.out.println(linkedlist + "맨뒤에서 삭제 ");
  }
}
