package FacadePattern;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FacadeTest {

  @Test
  @DisplayName("퍼사드 패턴을 적용한 객체의 인터페이스용 메서드에서 내부 객체의 메서드를 실행시킨다")
  public void facadeTest() throws Exception {
    DvdPlayer dvd = Mockito.spy(JDvdPlayer.class);
    CdPlayer cd = Mockito.spy(JCdPlayer.class);
    Projector projector = Mockito.spy(JProjector.class);
    HomeTheaterFacade htf = new HomeTheaterFacade(dvd, cd, projector);

    Assertions.assertThat(htf.watchMovie("island"))
        .isEqualTo("dvd oncd onprojector onisland");

  }

}