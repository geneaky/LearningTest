package FacadePattern;

public class JCdPlayer implements CdPlayer {


  @Override
  public String on() {
    return "cd on";
  }

  @Override
  public String off() {
    return "cd off";
  }
}
