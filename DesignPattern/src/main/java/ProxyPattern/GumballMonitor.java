package ProxyPattern;

public class GumballMonitor {

  //rmi 사용해서 서버 클라이언트 테스트를 해야함
  GumballMachine gumballMachine;

  public GumballMonitor(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  public String report() {
    return gumballMachine.getLocation();
  }
}
