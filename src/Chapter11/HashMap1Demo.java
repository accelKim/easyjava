package Chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMap1Demo {
  public static void main(String[] args) {
    Map<Fruits, Integer> fruits = new HashMap<>();
    System.out.println(fruits.size());
    fruits.put(new Fruits("사과"),10);
    fruits.put(new Fruits("바나나"),5);
    fruits.put(new Fruits("딸기"),3);

    fruits.put(new Fruits("사과"),3);

    System.out.println(fruits);


  }
}

class Fruits {
  String name;

  public Fruits(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof Fruits fruits) {
      if (this.name.equals(fruits.name)) {
        return true;
      }
    }
    return false;
  }

    @Override
    public String toString() {
      return "[" + name + "]";
    }
  }

