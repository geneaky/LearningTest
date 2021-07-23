package FacadePattern;

public class JDvdPlayer implements DvdPlayer {

  @Override
  public String on() {
    return "dvd on";
  }

  @Override
  public String off() {
    return "dvd off";
  }
}
