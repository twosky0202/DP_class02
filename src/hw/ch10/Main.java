package hw.ch10;

import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("20210821 이하늘");

        List<Student> list = new ArrayList<>();
        list.add(new Student("최승훈", "20210000", 175));
        list.add(new Student("이하늘", "20210821", 170));
        list.add(new Student("강다현", "20211111", 160));
        list.add(new Student("류정민", "20212222", 162));
        list.add(new Student("오지원", "20213333", 183));

        System.out.println("** (1) 정렬 결과 (오름차순)");
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);
        System.out.println();
        System.out.println("** (2) 정렬 결과 (내림차순)");
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);
    }
}
