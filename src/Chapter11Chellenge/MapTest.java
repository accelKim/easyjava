package Chapter11Chellenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>();

    map.put("김열공", 80);
    map.put("우등생", 90);
    map.put("최고봉", 70);
    map.put("나자바", 60);

    System.out.print("이름을 입력하세요 : ");
    String name = in.nextLine();
    System.out.println(map.get(name));
  }
}


