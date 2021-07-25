package StatePattern;

public class SoldOutState implements State {

  GamballMachine gamballMachine;

  public SoldOutState(GamballMachine gamballMachine) {
    this.gamballMachine = gamballMachine;
  }

  @Override
  public String insertQuarter() {
    return null;
  }
}
