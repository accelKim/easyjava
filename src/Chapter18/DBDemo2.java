package Chapter18;

import java.sql.*;

public class DBDemo2 {
  public static void main(String[] args) throws SQLException{
    Connection conn = makeConnection();
    Statement statement = conn.createStatement();

    String sql = "insert into person (name, phone, email) values ('홍길동', '013' , 'kya@naver.com');";

//    PreparedStatement preparedStatement = conn.prepareStatement(sql);
//    preparedStatement.setString(1, "김연아");
//    preparedStatement.setString(2, "012");
//    preparedStatement.setString(3, "kya@naver.com");

    int i = statement.executeUpdate(sql);

    if(i ==1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");

    conn.close();
    statement.close();
  }

  static Connection makeConnection(){
    String url = "jdbc:mysql://127.0.0.1/sample?serverTimezone=Asia/Seoul";

    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("데이터베이스 연결중....");
      conn = DriverManager.getConnection(url, "root", "1234");
      System.out.println("데이터베이스 연결 성공!!!");
      //conn.close();
    } catch (SQLException e) {
      //throw new RuntimeException(e);
      System.out.println("JDBC 드라이버를 찾지 못함");
    } catch (ClassNotFoundException e) {
//      throw new RuntimeException(e);
      System.out.println("데이터베이스 연결 실패");
    }
    return conn;
  }
}