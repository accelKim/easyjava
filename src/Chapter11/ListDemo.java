package Chapter11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
  public static void main(String[] args) {
    String[] animals = {"호랑이", "사자", "사슴", "곰"};
    List<String> list = Arrays.asList(animals);
    System.out.println(list);

    list.set(3, "앵무새");
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + "," );
    }
    System.out.println();

    // list.add(0, "바다표범"); abstracdList 라 사용 불가
    String[] animal2 = list.toArray(new String[0]);
    for (String ani1:animal2) {
      System.out.print(ani1 + ":");
    }
    System.out.println();
    list.set(1, "바다표범");

    list.sort((s1, s2) -> s1.length() - s2.length());
    list.forEach(s -> {System.out.println(s);});
    System.out.println(list);
  }

}
