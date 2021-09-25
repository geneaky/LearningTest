import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ActiveVerify {
  
@Test
@DisplayName("생성한 mock의 모든 상호작용을 기억하고 선택적으로 동작 검증")
public void isActiveVerify()
{
  //given
  List mocklist = mock(List.class);
  //when
  mocklist.add("One");
  mocklist.add("Two");
  mocklist.clear();
  //then
  verify(mocklist).add("One");
  verify(mocklist).clear();
}
}
