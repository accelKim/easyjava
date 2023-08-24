package Chapter9;

import java.util.ArrayList;

public class GenericIngeritanceDemo {
  public static void main(String[] args) {
    ArrayList<Beer> a1 = new ArrayList<>();
    ArrayList<Boricha> a2 = new ArrayList<>();
    ArrayList<Beverage> a3 = new ArrayList<>();
    a3.add(new Beverage());
    a3.add(new Beer());
    a3.add(new Boricha());
    Beer beverage = (Beer) a3.get(1);
    System.out.println(beverageTest(a3));

//    beverageTest(a2); 두 ArrayList 의 경우 상속 관계가 없다.
  }

  static boolean beverageTest(ArrayList<Beverage> array) {
    return true;
  }
}
