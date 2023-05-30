package ch07.practice;

public class Main {
    public static void main(String[] args) {
        // TextBuilder를 이용
        // Builder tb = new TextBuilder();
        TextBuilder tb = new TextBuilder();
        Director d1 = new Director(tb); // 구체적인 빌더를 외부에서 주입 -> Dependency Injection(의존성 주입)

        d1.construct();

        String result = tb.getTextResult(); // 1. Builder타입을 TextBuilder 타입으로 바꿈 2. tb를 타입캐스팅함
        // String result = ((TextBuilder)tb).getTextResult();

        System.out.println(result);

        // HTMLBuilder를 이용
        HTMLBuilder hb = new HTMLBuilder();
        Director d2 = new Director(hb);

        d2.construct();

        String result2 = hb.getHTMLResult();

        System.out.println("파일 " + result2 + " 가 생성되었습니다.");
    }
}
