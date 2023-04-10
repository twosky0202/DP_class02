package hw.ch05.idcard;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;

public class IDCardFactoryLeeHaNeul1 extends Factory {            
    
    private static IDCardFactoryLeeHaNeul1 iDCardFactoryLeeHaNeul1 = new IDCardFactoryLeeHaNeul1();

    private IDCardFactoryLeeHaNeul1(){
        System.out.println("인스턴스가 생성되었습니다.");
    }
    
    public static IDCardFactoryLeeHaNeul1 getInstance(){
        return iDCardFactoryLeeHaNeul1;
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
