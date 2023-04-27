package ch12.A2;

import java.util.ArrayList;
import java.util.List;

public class MultiStringDisplay extends Display {
    // 표시 문자열 저장 장소
    private List<String> body = new ArrayList<>();
    // 표시 문자열 최대 문자 수
    private int columns = 0;

    // 문자열 추가
    public void add(String msg) {
        body.add(msg);

        // 현재 더 긴 문자열이 추가된다면
        if (columns < msg.length()) {
            // 최대 문자 수 갱신
            columns = msg.length();
        }

        // 간격을 제일 긴 문자열에 맞춰줌
        updatePadding();
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return body.get(row);
    }

    // 표시 문자열 오른쪽 끝에 채울 공백을 필요에 따라 늘린다
    private void updatePadding() {
        for (int row = 0; row < body.size(); row++) {
            String line = body.get(row);
            // 빈 칸을 몇 개 채울까 계산
            int padding = columns - line.length();

            if (padding > 0) {
                body.set(row, line + spaces(padding)); // 문자열 + 빈칸한 것을 row에 넣어라
            }
        }
    }

    // count 수만큼의 공백을 만든다
    private String spaces(int count) {
        StringBuilder spaces = new StringBuilder();

        for (int i = 0; i < count; i++) {
            spaces.append(' ');
        }
        
        return spaces.toString();
    }
}
