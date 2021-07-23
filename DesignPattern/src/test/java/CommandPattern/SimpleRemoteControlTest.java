package CommandPattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SimpleRemoteControlTest {

  @Test
  @DisplayName("리모컨 버튼에 커맨드 객체를 할당하여 실행시키면 구현된 내용시 실행된다")
  public void commandTest() throws Exception {
    SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
    RoomLight roomLight = spy(RoomLight.class);
    LightOnCommand light = new LightOnCommand(roomLight);
    simpleRemoteControl.setSlot(light);

    when(roomLight.on()).thenReturn("불 켜");
//    when(roomLight.off()).thenReturn("불 꺼");

    Assertions.assertThat(simpleRemoteControl.buttonWasPressed()).isEqualTo("불 켜");
    verify(roomLight, times(1)).on();
  }

}