import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SequenceTest {

  static private int value = 0;
  static List<Integer> list = new ArrayList<>();

  static CountDownLatch countDownLatch = new CountDownLatch(3);

  public static synchronized int getNext(){


    return value++;
  }

  static class SequenceMulti implements Runnable{

    @Override
    public void run() {
      for(int i = 0; i<9;i++){
        list.add(getNext());
      }
      countDownLatch.countDown();
    }
  }

  @Test
  @DisplayName("getNext 동기화")
  public void syncGetNext() throws Exception{

    for(int i = 0; i<3;i++){
      new Thread(new SequenceMulti()).start();
    }

    countDownLatch.await();

    Assertions.assertThat(list).hasSize(27);

  }

}
