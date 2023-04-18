package ch10.A4b;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        // Comparator 인터페이스에는 compare() 메소드 하나만 선언되어 있음
        // 하나의 메소드만 선언되어 있는 인터페이스를 functional 인터페이스
        // Function 인터페이스를 구현한 객체가 들어갈 자리에는 람다식을 넣을 수 있다.
        list.sort((a, b) -> a.compareTo(b)); // 람다식(함수)
        System.out.println(list);

        // 사전식 순으로 큰 순서
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }
}
