package ch17.practice;

public class Main {
    public static void main(String[] args) {
        // 관찰대상 생성
        NumberGenerator generator = new RandomNumberGenerator();

        // 관찰자 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        // 관찰자를 관찰대상에 등록
        generator.addObserver(observer1);
        generator.addObserver(observer2);

        // 관찰대상에게 숫자 생성 요청
        generator.execute();
    }
}
