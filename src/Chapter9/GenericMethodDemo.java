package Chapter9;

import chapter08.Box;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericMethodDemo {
  public static void main(String[] args) {
    Integer[] ia = {1,2,3,4,5};
    Character[] ca = {'a', 'b','c','d','e'};
    Box[] ba = {new Box(), new Box()};
    ba[0].set(10);
    ba[1].set(20);
    Utils.showArray(ia); // [1,2,3,4,5]
    Utils.showArray(ca); // abcde
    Utils.showArray(ba);
    System.out.println(Utils.getLast(ia)); // 5
    System.out.println(Utils.getLast(ca)); // e
  }
}

class Utils {
  static <T> void showArray(T[] array){
    //System.out.println(Arrays.toString(array));
    for (T t:array) {
      System.out.printf("%s ", t);
    }
    System.out.println();
  }

  static <T> T getLast(T[] array){
    return array[array.length - 1];
  }

//  static void showArray(Character[] array){
//    System.out.println(Arrays.toString(array));
//  }
}
