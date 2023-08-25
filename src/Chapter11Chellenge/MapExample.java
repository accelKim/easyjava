package Chapter11Chellenge;

import java.util.*;

public class MapExample {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("blue", 96);
    map.put("hong", 86);
    map.put("white", 92);

    String name = null;
    int maxScore = 0;
    int totalScore = 0;

    Collection<Integer> values = map.values();
    maxScore = Collections.max(values);
    System.out.println("최고점수 " + maxScore);

    for (Integer value:values) {
      totalScore += value;
    }
    System.out.println("평균점수" + totalScore / values.size());

    Set<String> keys = map.keySet();
    System.out.println(keys);
    for (String key:keys
         ) {
      if (map.get(key) == maxScore) {
        name = key;
        System.out.println("최고 점수를 받ㅇ츤 아이디 " + name);
        return;
      }
    }
    Set<Map.Entry<String, Integer>> entries = map.entrySet();
    for (Map.Entry<String, Integer> entry: entries) {
      if (entry.getValue() == maxScore) {
        name = entry.getKey();
        System.out.println("최고점수를 받은 아이디 " + name);
        break;
      }
    }
  }
}

