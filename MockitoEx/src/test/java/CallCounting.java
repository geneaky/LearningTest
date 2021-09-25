import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CallCounting {

  @Test
  @DisplayName("몇 번 호출됐는지/최소한 한 번 호출됐는지 / 호출되지 않았는지 확인하기")
  public void callCount()
  {
    //given
   List mockedList = mock(List.class);

    //when
    mockedList.add("once");

    mockedList.add("twice");
    mockedList.add("twice");

    mockedList.add("tree times");
    mockedList.add("tree times");
    mockedList.add("tree times");
    //then

    //이 두 가지 검증 방법은 동일하다. times(1)은 기본값이라 생략되도 상관없다.
    verify(mockedList).add("once");
    verify(mockedList,times(1)).add("once");

    //정확히 지정된 횟수만큼만 호출되는지 검사
    verify(mockedList, times(2)).add("twice");
    verify(mockedList, times(3)).add("tree times");

    //never()를 이용하여 검증 times(0)과 같은 의미
    verify(mockedList, never()).add("never happened");

    //atLeast()와 atMost()를 이용한 검증
    verify(mockedList, atLeastOnce()).add("tree times");
    verify(mockedList, atLeast(2)).add("five times");
    verify(mockedList, atMost(5)).add("tree times");

  }

}
