package Chapter9;

public class EntryDemo {
  public static void main(String[] args) {
    Entry<String, Integer> entry = new Entry<>();
    entry.setKey("123");
    entry.setValue(20);
    System.out.println(entry.getKey());
    System.out.println(entry.getValue() * 10);

    Entry<Integer, String> entry1 = new Entry<>();
    entry1.setKey(10);
    entry1.setValue("123");
    System.out.println(entry1.getKey()/10);
    System.out.println(Integer.parseInt(entry1.getValue()));
  }
}
class Entry<K, V>{
  private K key;
  private V value;

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }
}
