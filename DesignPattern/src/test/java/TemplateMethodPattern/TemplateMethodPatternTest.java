package TemplateMethodPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TemplateMethodPatternTest {

  @Test
  @DisplayName("템플릿 메서드 패턴의 훅을 true로 설정하여 결과 값을 도출하는데 성공한다.")
  public void getCoffeeWhenHookReturnTrue() throws Exception {
    Coffee coffee = new Coffee();
    coffee.beverageHook(true);

    Assertions.assertThat(coffee.preparedRecipe()).isEqualTo("물 끓이고 필터로 커피를 우려내는중설탕과 커피를 추가하는중");

  }

  @Test
  @DisplayName("템플릿 메서드 패턴의 훅을 false로 설정하여 조건부 결과 값을 받는다.")
  public void NoCoffeeWhenHookReturnFalse() throws Exception {

    Coffee coffee = new Coffee();
    coffee.beverageHook(false);

    Assertions.assertThat(coffee.preparedRecipe()).isEqualTo("없습니다.");

  }

}