package ch20.Sample;

public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars; // 배열 선언

    // 생성자 
    public BigString(String string) {
        // 공장 얻음
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()]; // 배열 생성
        
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i)); // 공장에게 위임
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}
