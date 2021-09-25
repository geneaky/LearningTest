import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TimeOutMock {

  @Test
  @DisplayName("timeOut Check")
  public void timeOut()
  {
    List mock = mock(List.class);
d
    mock.add(1);
    mock.add(1);
    mock.add(1);

    verify(mock,timeout(100).times(3)).add(1);
    verify(mock,timeout(100).atLeast(3)).add(1);
  }

}
