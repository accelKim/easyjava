package Chapter9;

import java.util.ArrayList;

public class GenericClass1Demo {
  public static void main(String[] args) {
    ArrayList<Boricha> arrayListBoricha = new ArrayList<>();
    arrayListBoricha.add(new Boricha());
    //arrayListBoricha.add(new Beer());
    ArrayList<Beer> arrayListBeer = new ArrayList<>();
    arrayListBeer.add(new Beer());
    //arrayListBeer.add(new Boricha())

    Cup c = new Cup();
    c.setBeverage(new Boricha());
    if(c.getBeverage() instanceof Boricha){
      Boricha boricha = (Boricha) c.getBeverage();
    } else if (c.getBeverage() instanceof Beer){
      Beer beer= (Beer) c.getBeverage();
    }

    c.setBeverage(new Beer());
//    Beer beer= (Beer) c.getBeverage();
    Boricha bori = (Boricha) c.getBeverage();
    bori.drink();
    c.setBeverage(new Beverage());
    Beverage bev = (Beer) c.getBeverage();
//    c.setBeverage(new Object());
    //beer= (Beer) c.getBeverage();

    Cup<Boricha> borichaCup = new Cup();
    borichaCup.setBeverage(new Boricha());
    Boricha boricha = borichaCup.getBeverage();

    Cup<Beer> beerCup = new Cup<>();
    beerCup.setBeverage(new Beer());
    //beerCup.setBeverage(new Boricha());
    Beer beer = beerCup.getBeverage();
  }
}
class Beverage {}
class Boricha extends Beverage{
  void drink() {
    System.out.println("어린아이만 마실수 있다.");
  }
}
class Beer extends Beverage{
  void cheers() {
    System.out.println("어른만 마실수 있다");
  }
}
class Cup<T extends Beverage> {
  private T beverage;
  public T getBeverage() {
    return beverage;
  }
  public void setBeverage(T beverage) {
    this.beverage = beverage;
  }
}