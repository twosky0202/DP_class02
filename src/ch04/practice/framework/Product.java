package ch04.practice.framework;

public abstract class Product {
    // 컴파일 오류 -  생성자는 상속 x
    // public abstract Product(String name);

    public abstract void use();
}
