package SingletonPattern;

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
    //위 방식은 인스턴스를 lazy로딩이 가능하지만 멀티스레딩 환경에서 동기화 처리로 인한 속도 문제가 있다.

    /*
    * 그래서 처음부터 객체를 생성하는 방식도 사용한다.
    * private static Singleton uniqueInstance = new Singleton();
    *
    * private Singleton(){}
    *
    * public static Singleton getInstance(){
    *    return uniqueInstance;
    * }
    *
    * */
}
