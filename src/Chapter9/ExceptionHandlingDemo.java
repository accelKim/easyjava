package Chapter9;

import java.io.BufferedReader;
import java.nio.ByteBuffer;

public class ExceptionHandlingDemo {
  public static void main(String[] args) {
    int i = 3;
    String s = "";
    try {
      s.length();
      int res = 10 / i;
    } catch (ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다");
    } catch (NullPointerException e) {
      System.out.println("문자열의 내용이 없습니다");
    } catch (Exception e) {
      System.out.println("예외가 발생했습니다");
    } finally {
      System.out.println("프로그램을 종료합니다");
    }
  }
}
