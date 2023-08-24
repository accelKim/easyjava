package Chapter9;

import java.util.StringTokenizer;

public class Unchecked1Dedmo {
  public static void main(String[] args) {

  String s = "Time is money";
  StringTokenizer st = new StringTokenizer(s);
    while (st.hasMoreElements()) {
      System.out.println(st.nextToken());
    }
//    System.out.println(st.nextToken()); NosuchElementException 객체
  }
}
