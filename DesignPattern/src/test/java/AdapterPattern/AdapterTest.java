package AdapterPattern;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdapterTest {

  @Test
  @DisplayName("터키 객체가 오리 인터페이스를 어댑터를 사용해서 구현에 성공")
  public void isChangeInterfaceByAdapter() throws Exception {

    Turkey turkey = new WildTurkey();
    Duck turkeyAdapter = new TurkeyAdapter(turkey);

    assertThat(turkeyAdapter.quack()).isEqualTo("Gobble gobble");

  }

}