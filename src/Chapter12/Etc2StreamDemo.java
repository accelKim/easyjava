package Chapter12;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Etc2StreamDemo {
  public static void main(String[] args) {
    IntStream is1 = IntStream.iterate(1, x -> x + 2);

    IntStream is2 = new Random().ints(0, 10);

    Stream<Double> ds = Stream.generate(Math::random);

    IntStream range = IntStream.range(1, 5);
    range.forEach(System.out::println);
    IntStream rangeClosed = IntStream.rangeClosed(1, 5);
    rangeClosed.forEach(System.out::println);
  }
}
