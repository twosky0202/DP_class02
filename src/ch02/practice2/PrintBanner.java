package ch02.practice2;

// 어댑터 (위임을 이용)
public class PrintBanner extends Print { // java는 다중상속 불가능. 부모가 둘 이상 올 수 없음
    // 어댑티를 가리키는 변수
    private Banner banner;

    private String string;

    public PrintBanner(String string) { 
        this.string = string;
        banner = new Banner(string);
    }

    @Override
    public void printStrong() { // 12V
        banner.showWithAster(); // 어댑티의 220V 호출
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }
}
