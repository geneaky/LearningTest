package IteratorPattern;

import java.util.Iterator;

public class DinnerMenu {

  int numberOfItems = 0;
  MenuItem[] menuItems;

  public DinnerMenu(int numberOfItems, MenuItem[] menuItems) {
    this.numberOfItems = numberOfItems;
    this.menuItems = menuItems;
  }

  public Iterator createIterator() {
    return new DinnerMenuIterator(menuItems);
  }
}
