package Chapter12;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Optional1Demo {
  public static OptionalDouble divide(double x, double y) {
    return y == 0 ? OptionalDouble.empty() : OptionalDouble.of(x / y);
  }

  public static OptionalInt divide(int x, int y) {
    return y == 0 ? OptionalInt.empty() : OptionalInt.of(x / y);
  }

  public static void main(String[] args) {
    OptionalInt divideInt = divide(10, 2);
    System.out.println(divideInt);

    OptionalDouble divide = divide(10.0, 2.0);
    System.out.println(divide);
    System.out.println(divide.getAsDouble());
    System.out.println(10/2.0);

    OptionalDouble divideZero = divide(10.0, 0.0);
    System.out.println(divideZero);

    Optional<String> apple = Optional.of("apple");
    System.out.println(apple);
    System.out.println(apple.get());
  }
}
