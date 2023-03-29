package hw.ch03;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
