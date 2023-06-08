package ch17.Sample;

public class Main {
    public static void main(String[] args) {
        // 관찰 대상
        NumberGenerator generator = new RandomNumberGenerator();

        // 관찰자
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        // 관찰자 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        // 수 생성
        generator.execute();
    }
}
