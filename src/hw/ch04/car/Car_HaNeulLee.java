package hw.ch04.car;

import hw.ch04.framework.Product;

public class Car_HaNeulLee extends Product{
    private String modelName;

    public Car_HaNeulLee(String modelName){
        this.modelName = modelName;
    }

    @Override
    public void use() {
        System.out.println("모델명 " + this.getModelName() + "인 car를 사용합니다.");
    }
    
    public String getModelName() {
        return modelName;
    }
}
