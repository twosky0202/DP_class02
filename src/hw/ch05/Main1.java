package hw.ch05;

import hw.ch05.idcard.IDCardFactoryLeeHaNeul1;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("20210821 이하늘");
        
        IDCardFactoryLeeHaNeul1 factory1 = IDCardFactoryLeeHaNeul1.getInstance();
        IDCardFactoryLeeHaNeul1 factory2 = IDCardFactoryLeeHaNeul1.getInstance();

        if(factory1 == factory2){
            System.out.println("factory1과 factory2는 같은 인스턴스입니다.");
        } else {
            System.out.println("factory1과 factory2는 다른 인스턴스입니다.");
        }
    }
}
