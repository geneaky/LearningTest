package FacadePattern;

public class JProjector implements Projector {

  @Override
  public String on() {
    return "projector on";
  }

  @Override
  public String off() {
    return "projector off";
  }
}
