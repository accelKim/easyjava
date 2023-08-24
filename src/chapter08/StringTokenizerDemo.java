package chapter08;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
  public static void main(String[] args) {
    String s = "of the people, by the people, for the people";
    StringTokenizer st = new StringTokenizer(s);
    System.out.println(st.countTokens());

    StringTokenizer st1 = new StringTokenizer(",");
    System.out.println(st1.countTokens());

    while (st.hasMoreElements()) {
      System.out.println(st.nextToken());


    }
  }
}
