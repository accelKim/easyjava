package Chapter9;

import java.util.ArrayList;

public class GenericTest2 {
  public static void main(String[] args) {
    int num = 30;
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(10);
    nums.add(num);


    for (int i = 0; i < nums.size(); i++) {
      System.out.println((nums.get(i)) * 2);
    }

      String s = "world";
      ArrayList<String> strs = new ArrayList<>();
      strs.add("hello");
      strs.add(s);
      strs.add("");
      strs.add(null);


      for (int i = 0; i < strs.size(); i++) {
        String getStr = strs.get(i);
        if (getStr != null) {
          System.out.println(strs.get(i).length());
        } else {
          System.out.println("아무것도 없습니다");
        }
      }
    }
  }

