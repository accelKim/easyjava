package Chapter8Chellenge;

public class CircleTest {
  public static void main(String[] args) {
    Person p1 = new Person("111111", "홍길동");
    Person p2 = new Person("111111", "손흥민");


    if (p1.equals(p2)) {
      System.out.println("같은사람");
    } else {
      System.out.println("다른사람");
    }
  }
}

class Person{
  String num;
  String name;

 public Person(String  num, String name) {
   this.name = name;
   this.num = num;
 }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person person) {
      if (person != null && this.num.equals(((Person) obj).num)) {
        return true;
      }
    }
    return false;
  }
}