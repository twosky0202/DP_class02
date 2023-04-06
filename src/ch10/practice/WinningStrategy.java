package ch10.practice;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random; // 임이의 수 생성기
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed); // 시드가 같으면 동일한 숫자가 생성됨
    }

    @Override
    public Hand nextHand() {
        if (!won) { // 직전에 졌으면
            prevHand = Hand.getHand(random.nextInt(3)); // 손을 새로 얻는다.
        }
        // 직전에 이겼으면 직전 손을 그대로 리턴
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
