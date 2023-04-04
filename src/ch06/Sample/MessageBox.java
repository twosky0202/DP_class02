package ch06.Sample;

import ch06.Sample.framework.Product;

public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
        System.out.println(decochar + s + decochar);
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() { // 자기 복제 매소드
        Product p = null;
        try {
            p = (Product)clone(); // 실제로 복제품을 만드는 메소드
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
