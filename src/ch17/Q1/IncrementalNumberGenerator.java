package ch17.Q1;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;
    private int end;
    private int inc;

    public IncrementalNumberGenerator(int start, int end, int inc) {
        this.number = start;
        this.end = end;
        this.inc = inc;
    }

    // 수를 취득한다
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다
    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += inc;
        }
    }
}
