package Chapter12;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StatisticDemo {
  public static void main(String[] args) {
    IntStream is = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("sum : " +  is.sum());
    is =  IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println("avg : " + is.average().getAsDouble());

    Stream<String> ss = Stream.of("a", "b", "c", "d", "e");
    System.out.println("count" + ss.count());
    ss = Stream.of("a", "b", "c", "d", "e");
    System.out.println("max : " + ss.max((x,y) -> x.hashCode() - y.hashCode()).get());

    Stream<String> ss1 = Stream.of("a", "bb", "ccc", "d", "ee");//max ==> ccc
    System.out.println("max : " + ss1.max((x,y) -> x.length() - y.length()).get());
  }
}
