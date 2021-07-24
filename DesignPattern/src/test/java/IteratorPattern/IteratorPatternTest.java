package IteratorPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IteratorPatternTest {

  @Test
  @DisplayName("이터레이터 패턴으로 서로 다른 컬렉션을 가진 객체의 순회를 한 객체에서 여러 메서드나 알고리즘 추가 없이 실행가능")
  public void iteratorPatternTest() throws Exception {
    MenuItem menuitem1 = new MenuItem("돈까스", 12);
    MenuItem menuitem2 = new MenuItem("피자", 13);
    MenuItem[] menuItems = new MenuItem[2];
    menuItems[0] = menuitem1;
    menuItems[1] = menuitem2;
    DinnerMenu dinnerMenu = new DinnerMenu(2, menuItems);
    Waitress waitress = new Waitress(dinnerMenu);
    Assertions.assertThat(waitress.printMenu()).isEqualTo("돈까스피자");
  }
}