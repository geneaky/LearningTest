package CommandPattern;

public class LightOnCommand implements Command {

  Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public String execute() {
    return light.on();
  }
}