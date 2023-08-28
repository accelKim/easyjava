package ThisIsJava17Example;

import java.util.Arrays;
import java.util.List;
public class Example {
  public static void main(String[] args) {
    List<String> list = Arrays.asList(

        "This is a java book",
        "Lambda Expressions",
        "Java8 supports lambda expressions"
    );
    list.stream()

        .filter(x-> x.toLowerCase().contains("java"))
        .forEach(System.out::println);


  }
}