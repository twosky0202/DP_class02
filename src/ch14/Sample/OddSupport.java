package ch14.Sample;

public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) { // 홀수만 해결
            return true;
        } else {
            return false;
        }
    }
}
