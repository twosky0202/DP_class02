package hw.ch17;

public class Main {
    public static void main(String[] args) {
        // 관찰대상 생성
        NumberGenerator png = new PrintNumberGenerator();

        // 관찰자 생성
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new NamePrintObserver();

        // 관찰자를 관찰대상에 등록
        png.addObserver(observer1);
        png.addObserver(observer2);
        png.addObserver(observer3);

        // 관찰대상에게 숫자 생성 요청 -> 소수일 때만 출력
        png.execute();
    }
}
