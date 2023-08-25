package Chapter11;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
  public static void main(String[] args) {
    Map<String, Integer> fruits =
        Map.of("사과", 5, "바나나", 3, "포도", 10, "딸기", 1);
    Map<String, Integer> hashFruits = new HashMap<>(fruits);

    hashFruits.put("키위", 10);
    System.out.println(hashFruits);

    hashFruits.put("키위", 1);
    System.out.println(hashFruits);
    hashFruits.remove("키위");
    System.out.println(hashFruits);


    hashFruits.clear();
    System.out.println(hashFruits.size());
    System.out.println(hashFruits.isEmpty());
  }
}

