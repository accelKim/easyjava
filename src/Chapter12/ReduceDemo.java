package Chapter12;

import java.util.List;
import java.util.Optional;

public class ReduceDemo {
  public static void main(String[] args) {
    List<Integer> list = List.of(3, 4, 5, 1, 2);
    Integer i = list.stream().reduce((x, y) -> x + y).get();

    Integer i1 = list.stream().reduce(0, (x, y) -> x + y);


    Integer i2 = list.stream().reduce(1, (x, y) -> x * y);
    System.out.println(i2);


  }
}
