package ch04.practice.framework;

public abstract class Factory {
    public final Product create(String owner) {
        // 제품 생산 시의 큰 흐름을 결정 => 템플릿 메소드
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 자식이 구체적인 생산 방법을 결정 (무엇을 생산? 등록?) => Factory Method
    // protected abstract Product createProduct(String owner); // 선언
    protected Product createProduct(String owner){
        // 디폴트 구현
        return null;
    }; 
    protected abstract void registerProduct(Product product);
}
