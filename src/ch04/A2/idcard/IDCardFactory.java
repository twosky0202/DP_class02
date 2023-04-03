package ch04.A2.idcard;


import java.util.Hashtable;

import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;
    private Hashtable manager = new Hashtable<>();

    protected synchronized Product createProduct(String owner) {
        manager.put(serial, owner);
        manager.get(serial);
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
