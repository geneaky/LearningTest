import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefaultReturnValueNotStubbing {

  @Test
  @DisplayName("stubbing되지 않은 메소드에 기본 리턴값 설정하기")
  public void defaultReturnValue()
  {
    //given
    List list = Mockito.mock(List.class, Mockito.RETURNS_SMART_NULLS);
    //when
    System.out.println(list.get(0));
    //then

  }

}
