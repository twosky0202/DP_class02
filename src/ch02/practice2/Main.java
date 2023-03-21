package ch02.practice2;

public class Main {
    public static void main(String[] arg) {

        // Banner 이용하기
        // 가정 : Banner를 직접 클라이언트가 사용하지 못한다.
        // 소스 코드를 얻을 수 있다.
        Banner b = new Banner("lhn");
        b.showWithParen();
        b.showWithAster();

        // 어댑터를 이용하기
        // Banner 클래스를 수정해도 클라이언트는 영향을 안 받는다.
        // Banner 클래스를 수정하지 않고도 클라이언트가 원하는 형태로 사용할 수 있다.
        Print x = new PrintBanner("lhn"); // 어댑터 생성
        x.printWeak();
        x.printStrong();
    }
}
