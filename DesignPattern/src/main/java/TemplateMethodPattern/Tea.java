package TemplateMethodPattern;

public class Tea extends CaffeineBeverage {

  @Override
  String brew() {
    return "차를 우려내느중";
  }

  @Override
  String addCondimetns() {
    return "레몬을 추가하는중";
  }
}
