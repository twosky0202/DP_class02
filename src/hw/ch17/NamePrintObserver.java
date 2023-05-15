package hw.ch17;

public class NamePrintObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        for (int i = 0; i < generator.getNumber(); i++) {
            System.out.print("이하늘 ");
        }

        System.out.println("");
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
