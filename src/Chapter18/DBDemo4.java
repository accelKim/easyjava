package Chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBDemo4 {
  // Delete 구현
  public static void main(String[] args) throws SQLException{
    Connection conn = makeConnection();
    String sql = "delete from person where phone = ? ;";

    PreparedStatement preparedStatement = conn.prepareStatement(sql);

    preparedStatement.setString(1, "015");

    int i = preparedStatement.executeUpdate();

    if(i ==1) System.out.println("데이터 삭제 성공");
    else System.out.println("데이터 삭제 실패");

    conn.close();
    preparedStatement.close();
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

