package ch05.A3a;

public class Main extends Thread {
    public static void main(String[] args) {
        System.out.println("Start.");

        // 스레드 객체 3개를 만들고, 각각 시작시킴
        new Main("A").start(); // 스레드의 run을 자동으로 실행함
        new Main("B").start();
        new Main("C").start();
        System.out.println("End.");
    }

    @Override
    public void run() { // 이 스레드가 하는 일이 작성되어 있다.
        Singleton obj = Singleton.getInstance();
        System.out.println(getName() + ": obj = " + obj); // obj : 주소
    }

    public Main(String name) {
        super(name);
    }
}
