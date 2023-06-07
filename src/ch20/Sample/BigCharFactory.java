package ch20.Sample;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리
    private Map<String, BigChar> pool = new HashMap<>(); // key와 value 쌍을 관리하는 컬렉션. HashMap의 타입 생략 가능

    // Singleton 패턴
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) { // '1'
        // pool에 가서 이미 만든게 있는지 검사
        BigChar bc = pool.get(String.valueOf(charname)); // get() : 인자로 key값을 준다. String타입으로 바꿔주기 "1"
        
        if (bc == null) { // 이미 만든게 없으면
            // 여기서 BigChar 인스턴스를 생성
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc); // pool에 추가
        }
        return bc;
    }
}
