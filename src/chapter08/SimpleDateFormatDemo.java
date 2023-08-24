package chapter08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
  public static void main(String[] args) {
    Date date = new Date(2023,11,31);
    System.out.println(date);
    SimpleDateFormat sdf = new SimpleDateFormat("-MM-dd");
    System.out.println(sdf.format(date));
  }
}
