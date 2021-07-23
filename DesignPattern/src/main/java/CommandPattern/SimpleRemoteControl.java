package CommandPattern;

public class SimpleRemoteControl {

  Command slot;

  public SimpleRemoteControl() {
  }

  public void setSlot(Command slot) {
    this.slot = slot;
  }

  public String buttonWasPressed() {
    return slot.execute();
  }
}
