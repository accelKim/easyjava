package Chapter12;

import java.util.Optional;

public class FindDemo {
  public static void main(String[] args) {
    Optional<Nation> first = Nation.nations.stream().limit(4).findFirst();
    Optional<Nation> second = Nation.nations.stream().skip(1).findFirst();
    System.out.println(first.get());
    System.out.println(second.get());

    Optional<Nation> any = Nation.nations.stream().filter(x -> x.isIsland()).findAny();
    System.out.println(any.get());
  }
}
