package ch20.Sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata;

    // 생성자
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt"; // 파일 이름을 만듦
            StringBuilder sb = new StringBuilder(); // string 구축 클래스

            for (String line : Files.readAllLines(Path.of(filename))) { // 파일을 나타내는 경로를 한줄씩 읽는다. List<String>을 리턴한다
                sb.append(line);
                sb.append("\n");
            }

            this.fontdata = sb.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
