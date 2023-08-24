package Chapter11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
  public static void main(String[] args) {
    Collection<String> list = Arrays.asList("다람쥐", "개구리", "나비");

    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + "-");
    }
    System.out.println();

    Iterator<String> iterator1 = list.iterator();
    while (iterator1.hasNext()) {
      System.out.print(iterator1.next() + "-");
    }
  }
}
