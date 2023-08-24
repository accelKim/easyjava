package Chapter8Chellenge;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

public class CalendarTest {
  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    String[] weekName = {"일", "월", "화", "수", "목", "금", "토"};
    String[] noonName = {"오전", "오후"};
    Calendar c = Calendar.getInstance();

    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();
    System.out.println(year + "년" + month + "월" + day + "일");

    int am_pm = c.get(c.AM_PM);
    String noon;
    System.out.println(am_pm);
   DayOfWeek week = now.getDayOfWeek();
   if(am_pm == 1) {
      noon = "오후";
   } else {
      noon = "오전";
   }
    System.out.println(week + " " + noon);
    int hour = now.getHour();

    int minute = now.getMinute();
    int second = now.getSecond();
    System.out.println(hour + "시" + minute + "분" + second + "초");

  }

}


