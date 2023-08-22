public class GarbageDemo {
  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {
      new Garbage(i);
      System.gc();

    }
  }
}

class Garbage{
  int no;
  public Garbage(int no) {
    this.no = no;
    System.out.println("Garbage (" +no + ") 가 생성됨");
  }
  @Override
  protected void finalize() throws Throwable {
    System.out.println("Garbage (" +no + ") 가 수거됨");
  }
}
