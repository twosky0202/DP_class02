package ch10.A4a;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        // 익명의 클래스를 이용해서 Comparator 객체를 생성함 -> 한번만 쓰는 경우에 익명 클래스
        list.sort(new Comparator<String>() { // 타입 없으면 Object 비교
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(list);

        // 사전순으로 큰 순서
        list.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(list);
    }
}
