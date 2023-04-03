package ch04.practice.idcard;

import ch04.practice.framework.Product;

public class IDCard extends Product {
    private String owner;

    // visibility : 패키지 (같은 패키지에서만 호출 가능)
    // IDCard(String owner) {
    public IDCard(String owner) {
        // 부모의 인자없는 생성자가 자동으로 호출됨

        // 명시적으로 부모의 인자있는 생성자를 호출하고 싶으면
        // 꼭 첫 줄에 super(x, y, z)를 호출해야 함
        
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다."); 
        // this : 현재 idcard 객체. + : 문자열 연결, this.toString()이 자동 호출됨
    }

    @Override
    public String toString() { // Object 클래스로부터 상속
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}
