package FactoryPattern;

public class CheesePizza implements Pizza{
    @Override
    public String bake() {
        return "치즈 피자 굽다";
    }

    @Override
    public String cut() {
        return "치즈 피자 자르다";
    }
}
