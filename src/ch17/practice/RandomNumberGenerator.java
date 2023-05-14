package ch17.practice;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); // 난수 생성기
    private int number; // 현재 수(이 관찰 대상의 현재 상태)

    // 수를 취득한다
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50); // 0 ~ 49 사이의 임의의 수 생성 -> 상태 변화
            notifyObservers(); // 관찰자들에게 통지
        }
    }
}
