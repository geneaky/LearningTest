import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class OrderVerify {

  @Test
  @DisplayName("순서 검증하기")
  public void orderVerify()
  {
    //given
   List firstMock = mock(List.class);
   List secondMock = mock(List.class);

    //when
    // mock 사용
    firstMock.add("was called first");
    secondMock.add("was called second");

    //mock이 순서대로 실해되는지 확인하기 위해 inOrder 객체에 mock을 전달한다.
    InOrder inOrder = inOrder(firstMock,secondMock);

    //then
    inOrder.verify(firstMock).add("was called first");
    inOrder.verify(secondMock).add("was called second");

  }

}
