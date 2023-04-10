package hw.ch04.framework;

public abstract class Factory {
    public final Product create(String modelName) {
        Product p = createProduct(modelName);
        registerProduct(p);
        return p;
    }
    
    protected abstract Product createProduct(String modelName);
    protected abstract void registerProduct(Product product);
}
