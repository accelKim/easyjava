package Chapter18;

import java.sql.*;

public class DBDemo5 {
  // select 구현
  public static void main(String[] args) throws SQLException{
    Connection conn = makeConnection();
    String sql = "select * from person;";


    PreparedStatement preparedStatement = conn.prepareStatement(sql);

    ResultSet rs = preparedStatement.executeQuery();

    while (rs.next()) {
      System.out.println("name : " + rs.getString(1) + ",");
      System.out.println("phone : " + rs.getString("phone") + ",");
      System.out.println("email : " + rs.getString(3));

    }

    conn.close();
    int i = preparedStatement.executeUpdate();

    if(i ==1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");

    String sql1 = "update person set email = ? where phone = ?;";

    PreparedStatement ps = conn.prepareStatement(sql1);
    ps.setString(1, "hkd@naver.com" );
    ps.setString(2, "013");

    boolean execute = ps.execute();
    if(!execute) System.out.println("데이터 수정 성공");
    else System.out.println("데이터 수정 실패");

    conn.close();
    ps.close();
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

