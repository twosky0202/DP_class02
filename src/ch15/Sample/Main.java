package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        // Facade를 이용함
        // 객체생성없이 메소드 호출 -> static 메소드
        PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");
        PageMaker.makeWelcomePage("leehaneul0202@duksung.ac.kr", "welcome2.html");
    }
}
