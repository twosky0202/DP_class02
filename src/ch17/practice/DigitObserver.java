package ch17.practice;

public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(1000); // 1초 쉬었다가
        } catch (InterruptedException e) {
        }
    }
}
