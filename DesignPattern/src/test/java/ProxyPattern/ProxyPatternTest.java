package ProxyPattern;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProxyPatternTest {

  @Test
  @DisplayName("Proxy Pattern Test 객체에 접근 권한 부여 성공")
  public void proxyPatternTest() throws Exception {
    PersonBean joe = new PersonBeanImpl("joe");
    assertThat(joe.getName()).isEqualTo("joe");

    joe.setName("jo");
//  자신에대한 메서드 호출은 나이 설정 빼고 가능하게 접근을 제한한 proxy
    PersonBean ownerProxy = PersonBeanImpl.getOwnerProxy(joe);
    ownerProxy.setName("ju");
    assertThat(ownerProxy.getName()).isEqualTo("ju");

    assertThatThrownBy(() -> ownerProxy.setAge(12)).isInstanceOf(RuntimeException.class);

//   외부객체에 대한 메서드 호출은 이름 설정 빼고 접근 가능하게 제한을한 proxy
    PersonBean ju = new PersonBeanImpl("ju");
    PersonBean nonOwnerProxy = PersonBeanImpl.getNonOwnerProxy(ju);
    nonOwnerProxy.setAge(13);
    assertThat(ju.getAge()).isEqualTo(13);
    //외부객체에 대한 접근은 나이 변환까지 가능하지만

    assertThatThrownBy(() -> nonOwnerProxy.setName("jo")).isInstanceOf(RuntimeException.class);
    //외부객체에 이름을 변경하는 메서드는 호출을 제한한다.
  }

}