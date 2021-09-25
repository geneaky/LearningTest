import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FindUnneccesaryCalled {

  @Test
  @DisplayName("불필요하게 실해되는 코드 찾기")
  public void findUnneccesary()
  {
    //given
    List mockedList = mock(List.class);
    //when
    mockedList.add("one");
    mockedList.add("two");

    //then
    verify(mockedList).add("one");

    // verfiyNoMoreInteractions 메서드는 너무 자주 무분별하게 사용되어서는 안된다. 실행 여부를 검사하는 테스트 툴에서 간편하게 사용될수있는 방법임
    verifyNoMoreInteractions(mockedList);

  }

}
