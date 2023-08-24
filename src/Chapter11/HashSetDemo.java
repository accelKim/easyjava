package Chapter11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
  public static void main(String[] args) {
    Set<String> set = Set.of("A", "B", "C", "D", "E");
    HashSet<String> hashSet = new HashSet<>(set);
    hashSet.add("F");
    Iterator<String> iterator = hashSet.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();
    System.out.println(set);
    System.out.println(hashSet);

    boolean e = hashSet.add("E");
    if (!e) System.out.println("추가못함");

    System.out.println("E의 hashCode() = " + "E".hashCode());
    System.out.println("F의 hashCode() = " + "F".hashCode());

    if (!isExist(hashSet, "F")) hashSet.add("F");
    else System.out.println("F가 이미 존재합니다");


    if (!isExist(hashSet, "G")) hashSet.add("G");
    else System.out.println("G가 이미 존재합니다");
  }

  static <T> boolean isExist(Set<T> set, T obj) {
    boolean isExist = false;
    for (T ele : set) {
      if (ele.hashCode() == "G".hashCode()) {
        isExist = true;
        break;
      }
    }
    return isExist;
  }
}
