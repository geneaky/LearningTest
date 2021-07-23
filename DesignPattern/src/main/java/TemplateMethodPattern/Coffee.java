package TemplateMethodPattern;

public class Coffee extends CaffeineBeverage {

  @Override
  String brew() {
    return "필터로 커피를 우려내는중";
  }

  @Override
  String addCondimetns() {
    return "설탕과 커피를 추가하는중";
  }
}
