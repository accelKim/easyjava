package Chapter12;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class matchDemo {
  public static void main(String[] args) {
    boolean b1 = Stream.of("a1", "b2", "c3").anyMatch(s -> s.startsWith("c"));
    System.out.println(b1);
    boolean b2 = IntStream.of(1, 3, 5, 7, 9).allMatch(n -> n % 2 == 1);
    System.out.println(b2);
    List<Integer> list = List.of(1, 3, 5, 7, 9);
    boolean b = true;
    for (Integer i : list) {
      if (i % 2 == 1) {
        b = true;
      } else {
        b = false;
        break;
      }
    }
    System.out.println(b);

    boolean b3 = IntStream.of(1, 3, 5, 7, 9).noneMatch(n -> n % 2 == 0);
    System.out.println(b3);

    //모든 국가의 인구가 1억이 넘느지 아닌지 출력해라.(match를 이용)
    if (Nation.nations.stream().allMatch(h -> h.getPopulation() > 100.0)) {
      System.out.println("모든 국가의 인구가 1억이 넘는다");
    } else {
      System.out.println("모든 국가의 인구가 1억이 넘지 않는다");
    }
  }
}
