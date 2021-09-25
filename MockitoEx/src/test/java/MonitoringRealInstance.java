import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonitoringRealInstance {

  @Test
  @DisplayName("실제 객체 감시하기")
  public void mointorReal()
  {
    //given
    List list = new LinkedList();
    List spy = spy(list);
    //when
    when(spy.size()).thenReturn(100);
    //then
    spy.add("one");
    spy.add("two");

    System.out.println(spy.get(0));
    System.out.println(spy.size());

    verify(spy).add("one");
    verify(spy).add("two");

  }

  @Test
  @DisplayName("stubbing된 spy에 대해 when을 사용할 수 없는 경우가 있다.")
  public void warningPoint()
  {
    //given
    List list = new LinkedList();
    List spy = spy(list);
    //when
//    when(spy.get(0)).thenReturn("foo"); // realmethod 호출시 아직 list는 비어있으므로 IndexOutOfBoundsException이 발생함
    doReturn("foo").when(spy).get(0); // doReturn으로 stubbing 해주어야함
    //then
    System.out.println(spy.get(0));
  }

}
