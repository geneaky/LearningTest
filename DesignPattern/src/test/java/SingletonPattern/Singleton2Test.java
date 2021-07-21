package SingletonPattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Singleton2Test {

    @Test
    @DisplayName("인스턴스가 물리적 동치이다.")
    public void isOnlyOne() throws Exception
    {
        Singleton2 one = Singleton2.getInstance();
        Singleton2 two = Singleton2.getInstance();

        assertThat(one).isEqualTo(two);
    }

}