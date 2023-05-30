package ch07.practice;

public class TextBuilder extends Builder {
    private StringBuilder sb = new StringBuilder(); // vs StringBuffer.
    // 기능은 동일하지만 StringBuilder가 더 빠름. 그러나 StringBuilder는 멀티스레드를 지원하지 않는다.

    @Override
    public void makeTitle(String title) {
        sb.append("==============================\n");
        sb.append("[");
        sb.append(title);
        sb.append("]\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("■");
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String s : items) {
            sb.append("　- ");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("==============================\n");
    }

    public String getTextResult() {
        return sb.toString();
    }
}
