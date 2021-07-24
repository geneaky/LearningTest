package IteratorPattern;

import java.util.Iterator;

public class Waitress {

  DinnerMenu dinnerMenu;

  public Waitress(DinnerMenu dinnerMenu) {
    this.dinnerMenu = dinnerMenu;
  }

  public String printMenu() {
    Iterator dinnerIterator = dinnerMenu.createIterator();
    //다른 클래스의 iterator를 추가로 받아서 구성할 수 있음
    return printMenu(dinnerIterator);
  }

  private String printMenu(Iterator iterator) {
    String result = "";
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      result += menuItem.getName();
    }
    return result;
  }
}
