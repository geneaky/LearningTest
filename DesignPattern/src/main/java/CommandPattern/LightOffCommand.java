package CommandPattern;

public class LightOffCommand implements Command {

  Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public String execute() {
    return light.off();
  }
}
