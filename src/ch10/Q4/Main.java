package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        // 문자열 리스트 생성
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서(오름차순)
        list.sort(new ComparatorAscending());
        System.out.println(list);

        // 사전순으로 큰 순서(내림차순) 
        list.sort(new ComparatorDesending());
        System.out.println(list);
    }
}
