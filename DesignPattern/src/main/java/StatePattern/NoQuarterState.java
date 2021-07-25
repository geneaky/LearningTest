package StatePattern;

public class NoQuarterState implements State {

  GamballMachine gamballMachine;

  public NoQuarterState(GamballMachine gamballMachine) {
    this.gamballMachine = gamballMachine;
  }

  @Override
  public String insertQuarter() {
    gamballMachine.setState(gamballMachine.getHasQuarterState());
    return "동전을 넣었습니다.";
  }
}
