package Chapter12;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.net.InterfaceAddress;
import java.util.stream.Stream;

public class map1Demo {
  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("a1", "b1", "b2", "c1", "c2");
    s1.map(x -> x.toUpperCase())
        .forEach(System.out::println);
    Stream<Integer> i1 = Stream.of(1, 2, 3, 4, 5);
    i1.map(x -> x*10)
        .forEach(System.out::println);

    Stream<String> s2 = Stream.of("a1", "a2", "a3");
    s2.map(s -> s.substring(1))
        .mapToInt(x -> Integer.parseInt(x))
        .mapToObj(x -> "b" + x)
        .forEach(System.out::println);

    s2 = Stream.of("a1", "a2", "a3");
    s2.map(s-> s.substring(1))
        .mapToInt(Integer::parseInt)
        .mapToDouble(i -> i*1.0)
        .forEach(System.out::println);
  }
}
