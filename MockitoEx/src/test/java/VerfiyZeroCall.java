import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VerfiyZeroCall {

  @Test
  @DisplayName("mock이 실해되지 않았는지 확인하기")
  public void verifyZeroCall()
  {
    //given
   List mockOne = mock(List.class);
   List mockTwo = mock(List.class);
   List mockThree = mock(List.class);
    //when
    mockOne.add("one");
    //then
    verify(mockOne).add("one");
    verify(mockOne, never()).add("two");

    //다른 mock이 호출되지 않았는지 검증
    verifyNoInteractions(mockTwo,mockThree);

  }

}
