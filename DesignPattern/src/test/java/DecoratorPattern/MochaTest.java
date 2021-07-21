package DecoratorPattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MochaTest {

    @Test
    @DisplayName("데코레이터를 적용하지 않은 음료는 기본 가격과 동일")
    public void noDecorateEspresso() throws Exception
    {
        Beverage beverage = new Espresso();
        assertThat(beverage.cost()).isEqualTo(1.99);
    }

    @Test
    @DisplayName("데코레이터를 적용한 음료의 가격은 추가된다.")
    public void DecorateHouseBlendMocha() throws Exception
    {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        assertThat(beverage.cost()).isEqualTo(1.09);

    }

}