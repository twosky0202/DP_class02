package hw.ch17;

import java.util.Random;

public class PrintNumberGenerator extends NumberGenerator {
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
            number = random.nextInt(100) + 1; // 1 ~ 100 사이의 임의의 수 생성 -> 상태 변화
            if (isPrimeNumber(number)) { // 숫자가 소수일 때만
                notifyObservers(); // 관찰자들에게 통지
            }
        }
    }

    public boolean isPrimeNumber(int num) { // 소수인지 검사
        // i : num에 나눌 값, for문을 한 바퀴 돌 때마다 1씩 증가한다.
        for (int i = 2; i < num; i++) {
            // 순차적으로 i를 num에 나누어본다.
            if (num % i == 0) {
                // num이 i로 나눠져 나머지가 0이 되면 false를 반환한다.
                return false;
            }
        }
        return true;
    }
}
