package Chapter12;

import java.util.Arrays;
import java.util.List;

public class Map3Demo {
  public static void main(String[] args) {
    List<String> list = List.of("안녕 , 자바!", "잘 가, C++");
    list.stream()
        .flatMap(x -> Arrays.stream(x.split(" ")))
        .forEach(Util::printWithParenthesis);
  }
}
