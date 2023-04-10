package hw.ch04.car;

import java.util.Iterator;
import java.util.Vector;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class CarFactory extends Factory{
    Vector<String> modelNames = new Vector<String>();

    @Override
    protected Product createProduct(String modelName) {
        return new Car_HaNeulLee(modelName);
    }

    @Override
    protected void registerProduct(Product product) {
        modelNames.add(((Car_HaNeulLee) product).getModelName());
    }

    public void printAllModelNames(){
        Iterator<String> iterator = modelNames.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
}
