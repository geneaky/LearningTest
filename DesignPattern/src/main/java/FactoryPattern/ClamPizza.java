package FactoryPattern;

public class ClamPizza implements Pizza {
    @Override
    public String bake() {
        return "조개 피자 굽다";
    }

    @Override
    public String cut() {
        return "조개 피자 자르다";
    }
}
