package StatePattern;

public class SoldState implements State {

  GamballMachine gamballMachine;

  public SoldState(GamballMachine gamballMachine) {
    this.gamballMachine = gamballMachine;
  }

  @Override
  public String insertQuarter() {
    return null;
  }
}
