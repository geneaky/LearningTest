import static org.mockito.Mockito.*;

import java.util.List;
import java.util.regex.Matcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;

public class ArgumentMatching {
/*
* Mockito는 자연스로운 자바 스타일(equals()를 이용한 비교)로 파라미터를 검증한다.
* 하지만 가끔 유연하게 파라미터를 검증하고 싶을 때 argument matcher를 사용할 수 있다.
* */
  @Test
  @DisplayName("파라미터 검증")
  public void argMatching()
  {
    //given
    List mockList = mock(List.class);
    //when
    //내장된 argument matcher인 anyInt()를 이용한 stubbing
    when(mockList.get(anyInt())).thenReturn("element");

    //then
    System.out.println(mockList.get(999));
    verify(mockList).get(anyInt());

  }

}
