package Chapter11Chellenge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class PersonTest {
  public static void main(String[] args) {
    Set<Person> set = new HashSet<>();
    set.add(new Person("김열공", 20));
    set.add(new Person("우등생", 16));
    set.add(new Person("최고봉", 56));
    set.add(new Person("나자바", 35));



    Iterator<Person> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();

    set.add(new Person("나자바", 35));
    iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + ":");
    }
    System.out.println();
  }

}

class Person {
  String name;
  int age;
  public Person() {}

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  @Override
  public int  hashCode() {
    return name.hashCode() +age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
  }
}

