package ch04.practice.idcard;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;

public class IDCardFactory extends Factory {                                                                    
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
