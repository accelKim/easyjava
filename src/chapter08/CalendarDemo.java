package chapter08;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
  public static void main(String[] args) {
    Date now = new Date();
    System.out.println(now);

    Calendar c = Calendar.getInstance();
    System.out.println(c);
    System.out.printf("%d년%d월%d일 입니다 \n"
        ,c.get(Calendar.YEAR)
        ,c.get(Calendar.MONTH)+1
        ,c.get(Calendar.DATE));


  }
}
