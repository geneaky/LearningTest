package StatePattern;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatePatternTest {

  @Test
  @DisplayName("스테이트 패턴 동작 성공")
  public void statePatternTest() throws Exception {

    GamballMachine gamballMachine = new GamballMachine(3);
//   따로 상태를 지정하지 않고 스테이트 패턴을 사용하여 패턴을 사용하는 객체 내부에서 구성 객체들이 각각 상태를 가지고
//    상태에 따른 동작을 하게끔 구성 객체의 생성시 this를 사용하여 자기 자신의 인스턴스를 제공해준다.
    Assertions.assertThat(gamballMachine.getHasQuarterState().insertQuarter()).isEqualTo("넣음");

  }

}