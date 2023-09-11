package Chapter18;

import com.sun.security.jgss.GSSUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Demo_Madang {
  public static void main(String[] args) {
    Book book = new Book();
    Scanner in = new Scanner(System.in);
    Connection conn = null;

    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost/madang?useSSL=false";
      conn = DriverManager.getConnection(url, "root", "1234");
      System.out.println("연결성공");
    }
    catch (ClassNotFoundException e) {
      System.out.println("Failed");
    }
    catch (SQLException e){
      System.out.println("error");
    }
    finally {
      try {
        if (conn != null && !conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    while (true) {
      System.out.println("불러올 목록을 선택해주세요");
      System.out.println("-------------------------------------------");
      System.out.println("1.책 목록 2.고객 목록 3.주문확인 -1.시스템 종료");
      System.out.println("11.도서추가등록 12고객추가등록 13.주문등록");
      System.out.println("21.도서정보수정 22고객정보수정 23.주문수정");
      System.out.println("31.도서정보삭제 32고객정보삭제 33.주문취소");
      System.out.println("-------------------------------------------");
      System.out.println();
      System.out.print("번호를 입력하세요 : ");
      int num = in.nextInt();
      try {

        if (num == 1) {
          book.book();
          continue;
        } else if (num == 2) {
          book.customer();
          continue;
        } else if (num == 3) {
          System.out.print("조회할 주문번호를 입력해주세요 : ");
          book.order(in.nextInt());
          continue;
        } else if (num == -1) {
          System.out.println("시스템을 종료합니다");
          break;
        } else if (num == 11) {
            book.addBook();
        } else if (num == 12) {
            book.addCustomer();
          continue;
        } else if (num == 13) {
          book.addOrder();
          continue;
        } else if (num == 21) {
            book.changeBook();
          continue;
          } else if (num == 31) {
          book.deleteBook();
          continue;
        } else {
          System.out.println("존재하지 않는 목록입니다");
          continue;
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
     }
    }
  }

  class Book{
    Scanner in = new Scanner(System.in);
    LocalDate now = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formatedNow = now.format(formatter);

    String driver = "oracle.jdbc.driver.OraCleDriver";
    String url = "jdbc:mysql://localhost/madang?useSSL=false";
    Connection conn;



    {
      try {
        conn = DriverManager.getConnection(url, "root", "1234");
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    ;

    public void book() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "select * from madang.book";
      try {
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        System.out.println("bookid \tbookname\tpublisher\tprice");
        while (rs.next()) {
          String bookid = rs.getString("bookid");
          String name = rs.getString(2);
          String pb = rs.getString(3);
          String price = rs.getString(4);
          System.out.println(bookid+"\t\t"+name+"\t"+ pb + "\t" + price);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    public void addBook() throws SQLException {
      String sql  = "select max(bookid) from book";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      int bookid = 0;
if(rs.next()){
   bookid = rs.getInt(1);
}
      try {

        sql = "insert into book values (?,?,?,?)";
        ps = conn.prepareStatement(sql);
        System.out.print("책이름 : ");
        String bookname = in.nextLine();
        System.out.print("출판사 : ");
        String publisher = in.nextLine();
        System.out.print("가격 : ");
        int price = in.nextInt();

        ps.setInt(1, bookid + 1);
        ps.setString(2,bookname);
        ps.setString(3, publisher);
        ps.setInt(4, price);
        int cnt  =  ps.executeUpdate();
        System.out.println("추가가 완료되었습니다");

      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    public void changeBook() throws SQLException {
      System.out.println("수정할 책의 id를 입력하세요");
      int bookid = in.nextInt();
      String sql =" Select bookname, publisher, price from book where bookid = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1,bookid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        System.out.println(rs.getString(1) + ","
            + rs.getString(2) + ","
            + rs.getInt(3));
      }
      sql = "update book set bookname = ?, publisher = ?, price = ?";
      try {
        ps = conn.prepareStatement(sql);
        System.out.print("도서 이름 : ");
        in.nextLine();
        String bookname = in.nextLine();
        System.out.print("출판사 : ");
        String publisher = in.nextLine();
        System.out.print("가격 : ");
        int price = in.nextInt();
        while (rs.next())
          if (bookname != null) {
            ps.setString(1, bookname);
          } else {
            break;
          }
        while (rs.next())
          if (publisher != null) {
            ps.setString(2, publisher);
          } else {
            break;
          }
        while (rs.next())
          if (price != 0) {
            ps.setInt(3, price);
          } else {
            break;
          }
        int cnt  =  ps.executeUpdate();
        System.out.println("수정이 완료되었습니다");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    public void deleteBook() throws SQLException {
      String sql = "delete from book where bookid = ?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      int count = 0;
      try {
        ps = conn.prepareStatement(sql);
        System.out.println("삭제할 도서번호를 입력해주세요 : ");
        int bookId = in.nextInt();
        ps.setInt(1, bookId);
        int cnt = ps.executeUpdate();
        System.out.println("삭제가 완료되었습니다");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }


    public void customer() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "select * from madang.customer";
      try {
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        System.out.println("custid\tname\taddress\t\tphone");
        while (rs.next()) {
          String custid = rs.getString("custid");
          String name = rs.getString(2);
          String add = rs.getString(3);
          String ph = rs.getString(4);
          System.out.println(custid + "\t\t" + name + "\t" + add + "\t" + ph);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    public void addCustomer() throws SQLException {
      String sql  = "select max(custid) from book";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      int custid = 0;
      if(rs.next()){
        custid = rs.getInt(1);
      }
       sql = "insert into customer values (?,?,?,?)";
      try {
        ps = conn.prepareStatement(sql);
        System.out.print("고객 이름 : ");
        String bookname = in.nextLine();
        System.out.print("주소지 : ");
        String address = in.nextLine();
        System.out.print("전화번호 : ");
        String phone = in.nextLine();

        ps.setInt(1, custid+1);
        ps.setString(2,bookname);
        ps.setString(3, address);
        ps.setString(4, phone);
        int cnt  =  ps.executeUpdate();
        System.out.println("추가가 완료되었습니다");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    public void deleteCustomer() throws SQLException {
      String sql = "delete from customer where custid = ?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
        ps = conn.prepareStatement(sql);
        System.out.println("삭제할 고객번호를 입력해주세요 : ");
        int custid = in.nextInt();
        ps.setInt(1, custid);
        int cnt = ps.executeUpdate();
        System.out.println("삭제가 완료되었습니다");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }


    public void order(int id) {
      String sql = "select * from madang.orders where orderid = ?";
      PreparedStatement ps = null;
      try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        System.out.println("ordreid\tcustid\tbookid\tsaleprice\torderdate\tbname");
        if (rs.next()) {
          String orderid = rs.getString("orderid");
          String custid = rs.getString(2);
          String bookid = rs.getString(3);
          String saleprice = rs.getString(4);
          String orderdate = rs.getString(5);
          String bname = rs.getString(6);
          System.out.println(orderid+ "\t\t" + custid + "\t\t" + bookid + "\t\t" + saleprice +"\t"+ orderdate + "\t\t" + bname);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    public void addOrder(){
      PreparedStatement ps = null;
      ResultSet rs = null;
      String sql = "insert into orders(custid,bookid,saleprice,orderdate) values (?,?,?,?)";
      try {
        ps = conn.prepareStatement(sql);
        System.out.print("고객 번호 : ");
        int custid = in.nextInt();
        System.out.print("책 번호 : ");
        int bookid = in.nextInt();
        System.out.print("판매가 : ");
        int saleprice = in.nextInt();
        String orderdate = formatedNow;

        ps.setInt(1, custid);
        ps.setInt(2,bookid);
        ps.setInt(3, saleprice);
        ps.setString(4, orderdate);
        int cnt  =  ps.executeUpdate();
        System.out.println("추가가 완료되었습니다");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    public void deleteorders() throws SQLException {
      String sql = "delete from orders where orderid = ?";
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
        ps = conn.prepareStatement(sql);
        System.out.println("삭제할 주문번호를 입력해주세요 : ");
        int orderid = in.nextInt();
        ps.setInt(1, orderid);
        int cnt = ps.executeUpdate();
        System.out.println("삭제가 완료되었습니다");
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }





