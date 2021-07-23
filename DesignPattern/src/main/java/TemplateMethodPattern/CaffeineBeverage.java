package TemplateMethodPattern;

public abstract class CaffeineBeverage {

  boolean beverageCondition;

  final String preparedRecipe() {

    if (beverageCondition) {

      return boilWater() + brew() + addCondimetns();
    }
    return "없습니다.";
  }

  abstract String brew();

  abstract String addCondimetns();

  private String boilWater() {
    return "물 끓이고 ";
  }

  public void beverageHook(boolean condition) {
    this.beverageCondition = condition;
  }

}
