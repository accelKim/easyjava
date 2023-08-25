package Chapter10;

public class FunchionalFaceDemo {
public static void main(String[] args) {
    MyFunction f = (a, b) -> a > b ? a : b ;

    int max = f.max(4, 6);
    System.out.println(max);
    }
    }

@FunctionalInterface
interface MyFunction {
  int max(int a, int b);
//  int min(int a, int b);
}
