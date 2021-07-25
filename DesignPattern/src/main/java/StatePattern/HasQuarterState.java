package StatePattern;

public class HasQuarterState implements State {

  GamballMachine gamballMachine;

  public HasQuarterState(GamballMachine gamballMachine) {
    this.gamballMachine = gamballMachine;
  }

  @Override
  public String insertQuarter() {
    return "넣음";
  }
}
