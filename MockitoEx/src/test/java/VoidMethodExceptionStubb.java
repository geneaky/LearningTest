import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VoidMethodExceptionStubb {

  @Test
  @DisplayName("void method의 exception stubbing")
  public void exceptionStubbing()
  {
    //given
    List mockedList = mock(List.class);
    //when
    doThrow(new RuntimeException()).when(mockedList).clear();
    //then
    Assertions.assertThrows(RuntimeException.class ,()->{
      mockedList.clear();
    });
  }

}
