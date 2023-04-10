package hw.ch04.car;

import java.util.Iterator;
import java.util.Vector;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class CarFactory extends Factory{
    Vector<Product> modelNames = new Vector<Product>();

    @Override
    protected Product createProduct(String modelName) {
        return new Car_HaNeulLee(modelName);
    }

    @Override
    protected void registerProduct(Product product) {
        modelNames.add(product);
    }

    public void printAllModelNames(){
        Iterator<Product> iterator = modelNames.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
}
