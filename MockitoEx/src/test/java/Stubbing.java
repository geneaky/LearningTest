import static org.mockito.Mockito.*;

import java.util.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Stubbing {

  @Test
  @DisplayName("구체 클래스 stubbing")
  public void doStubbing()
  {
    //given
    LinkedList mockList = mock(LinkedList.class);
    //when
    when(mockList.get(0)).thenReturn("first");
    when(mockList.get(1)).thenThrow(new RuntimeException());
    //then
    System.out.println(mockList.get(0)); // mockList의 첫 번째 요소로 반환하도록 등록해둔(stubbing) 값을 출력
//    System.out.println(mockList.get(1)); // RuntimeException
    System.out.println(mockList.get(999)); // 999번째 element는 mockList 동작으로 stub 되어있지 않으므로 null 출력

    // stubbing된 부분의 호출 여부 검증 (stubbing 동작을 검증하는 거라 불필요하긴함, 짜고치는 고스톱 느낌?)
    verify(mockList).get(0);

  }

}
