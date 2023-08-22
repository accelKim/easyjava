package chapter08;

public class StringBuilderDemo {
  public static void main(String[] args) {
    String s = new String("hi");
    System.out.println(s.hashCode());
    s = s + "!";
    System.out.println(s.hashCode());

    StringBuilder sb = new StringBuilder("Hello World");
    System.out.println(sb.hashCode());
    sb = sb.append("!");
    System.out.println(sb.hashCode());
    System.out.println("버퍼의 크기 = " + sb.capacity());
    sb = sb.delete(0, 1);
    System.out.println("삭제 = " + sb);
    sb = sb.insert(0, "H");
    System.out.println("추가 = " + sb);
    sb = sb.replace(0, 5, "Hi");
    System.out.println("대체 = " + sb);
    sb = sb.reverse();
    System.out.println("역전 = " + sb);
  }

}
