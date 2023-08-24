package Chapter8Chellenge;

public class StrudentTest {
  public static void main(String[] args) {
    System.out.println(new Student("김삿갓"));
    System.out.println(new Student("홍길동"));
  }
}

class Student {
  String name = "";
  public Student(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        '}';
  }
}
