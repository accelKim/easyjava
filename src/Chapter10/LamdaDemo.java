package Chapter10;

public class LamdaDemo {
  public static void main(String[] args) {
    Object obj = new Object() {
      int max(int a, int b){
        return a > b ? a : b;
      }
    };

    //int max = obj.max(3,5);
  }
}


