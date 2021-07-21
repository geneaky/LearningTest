package SingletonPattern;
//dcl : double checking locking을 사용한 동기화되는 부분을 줄인다.
//dcl을 사용하면 인스턴스가 생성되어 있는지 확인한 다음 생성되어 있지 않았을 때만 동기화를 할 수 있다.
//즉 처음에만 동기화를 진행하고 나중에는 동기화를 하지 않아도 된다.
public class Singleton2 {
    private volatile  static Singleton2 uniqueInstance;
    //volatile을 사용해서 cpu에 캐시를 비워 항상 메모리에서 값을 읽어오기때문에 동기화로 반영된 값을 읽는다.

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(uniqueInstance==null){
            synchronized (Singleton2.class){
                if(uniqueInstance==null){
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }
}
