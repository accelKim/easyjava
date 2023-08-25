package Chapter11Chellenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiFunction;

public class HashMapTest {
  public static void main(String[] args) {
    Map<String, String> animals = Map.of("호랑이", "tiger", "표범", "leopard", "사자", "lion");
    HashMap<String, String> map = new HashMap<>(animals);

    System.out.println(map);

    map.replaceAll((k,v) -> v.toUpperCase());

    System.out.println(map);


  }
}
