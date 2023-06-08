package ch17.Sample;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); // 난수 생성기
    private int number; // 현재 수

    // 수를 취득한다
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50); // 0~49
            notifyObservers(); // 관찰자에게 통지
        }
    }
}
