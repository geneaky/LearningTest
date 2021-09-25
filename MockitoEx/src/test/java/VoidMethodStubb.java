import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VoidMethodStubb {

  @Test
  @DisplayName("void 메소드 stubbing | doThrow() | doAnwer() | doNothing()")
  public void voidStubb()
  {
    //given
    List mockedList = mock(List.class);
    //when
    doThrow(new RuntimeException()).when(mockedList).clear();
    doNothing().when(mockedList).add(1,1);
    //then
    Assertions.assertThrows(RuntimeException.class,() ->{
      mockedList.clear();
    });
    verify(mockedList,never()).add(1);
  }

}
