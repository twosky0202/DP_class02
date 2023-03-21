package ch02.practice1;

// 어댑터 (상속을 이용한 어댑터) : 부모(Banner)를 상속받고 target interface(Print)를 구현해줌
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) { // 생성자
        super(string); // 부모 생성자
    }

    @Override
    // 메소드 이름이 변환된다.
    public void printWeak() { // 12V
        showWithParen(); // 220V
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
