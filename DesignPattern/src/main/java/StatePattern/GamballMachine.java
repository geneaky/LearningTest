package StatePattern;

public class GamballMachine {

  State soldOutState;
  State noQuarterState;
  State hasQuarterState;
  State soldState;

  State state = soldOutState;
  int count = 0;

  public GamballMachine(int numberGumballs) {
    this.soldOutState = new SoldOutState(this);
    this.noQuarterState = new NoQuarterState(this);
    this.hasQuarterState = new HasQuarterState(this);
    this.soldState = new SoldState(this);
    this.count = count;
    if (numberGumballs > 0) {
      state = noQuarterState;
    }
  }


  public void setState(State state) {
    this.state = state;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }
}
