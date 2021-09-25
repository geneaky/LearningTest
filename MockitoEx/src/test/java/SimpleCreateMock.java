import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimpleCreateMock {

  @Mock
  List<String> mockedList;

  @Test
  @DisplayName("Mock 간단하게 생성")
  public void simpleCreateMock()
  {
    //given

    //when
    mockedList.add("one");
    //then
    verify(mockedList).add("one");
  }

}
