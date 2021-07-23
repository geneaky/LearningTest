package AdapterPattern;

public class TurkeyAdapter implements Duck {

  Turkey turkey;

  public TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }

  @Override
  public String quack() {
    return turkey.gobble();
  }

  @Override
  public String fly() {
    return turkey.fly();
  }
}
