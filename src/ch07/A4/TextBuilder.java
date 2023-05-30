package ch07.A4;

public class TextBuilder extends Builder {
    private String text = ""; // String 클래스를 사용하면 문자열 수정이나 추가 시 매번 새로운 String 객체를 만들기 때문에 속도가 느림

    @Override
    public void makeTitle(String title) {
        text += "==============================\n";
        text += "[" + title + "]\n";
        text += "\n";
    }

    @Override
    public void makeString(String str) {
        text += "■" + str + "\n";
        text += "\n";
    }

    @Override
    public void makeItems(String[] items) {
        for (String s : items) {
            text += "　- " + s + "\n";
        }
        text += "\n";
    }

    @Override
    public void close() {
        text += "==============================\n";
    }

    public String getTextResult() {
        return text;
    }
}
