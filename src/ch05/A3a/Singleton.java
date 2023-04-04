package ch05.A3a;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown(); // 생성 시 시간이 걸리게 하기 위해서
    }

    // public static Singleton getInstance() {
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton(); // lazy initialiation
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); // 1초간 쉰다
        } catch (InterruptedException e) {
        }
    }
}
