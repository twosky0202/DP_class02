package hw.ch05;

import hw.ch05.idcard.IDCardFactoryLeeHaNeul2;

public class Main2 extends Thread {
    public static void main(String[] args) {
        System.out.println("20210821 이하늘");

        new Main2("최승훈").start();
        new Main2("이하늘").start();
        new Main2("이찬비").start();
    }

    @Override
        public void run() {
            IDCardFactoryLeeHaNeul2 obj = IDCardFactoryLeeHaNeul2.getInstance();
            System.out.println(getName() + ": obj = " + obj);
        }

    public Main2(String name) {
        super(name);
    }
}
