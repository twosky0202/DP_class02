package hw.ch14;

public class PrimeNumberSupport extends Support {
    public PrimeNumberSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (isPrimeNumber(trouble.getNumber())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPrimeNumber(int num) {
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
