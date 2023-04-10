package hw.ch05.idcard;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;

public class IDCardFactoryLeeHaNeul2 extends Factory {                                                                    
    private static IDCardFactoryLeeHaNeul2 idCardFactoryLeeHaNeul2 = null;

    private IDCardFactoryLeeHaNeul2() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown();
    }

    public static synchronized IDCardFactoryLeeHaNeul2 getInstance() {
        if (idCardFactoryLeeHaNeul2 == null) {
            idCardFactoryLeeHaNeul2 = new IDCardFactoryLeeHaNeul2();
        }
        return idCardFactoryLeeHaNeul2;
    }

    private void slowdown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
