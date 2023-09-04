package Chapter18;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressDemo {
  public static void main(String[] args) {
    InetAddress addr1 = null, addr2 = null;
    System.out.println("호스트 이름을 입력하세요 :");
    Scanner in = new Scanner(System.in);
    String url = in.nextLine();

    try {
      addr1 = InetAddress.getByName(url);
      addr2 = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }
    System.out.println(url + " : " + addr1.getHostAddress());
    System.out.println("local IP : " + addr2.getHostAddress());
  }
  }
