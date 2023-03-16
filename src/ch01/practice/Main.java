package ch01.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class Main {
    public static void main(String[] args) {
        // 책 생성
        Book b1 = new Book("book1");
        // System.out.println(b1.getName());

        Book b2 = new Book("book2");

        // 책꽂이 생성
        BookShelf bs1 = new BookShelf(10);

        bs1.appendBook(b1);
        bs1.appendBook(b2);

        Book result = bs1.getBookFrom(0);
        // System.out.println(result.getName());

        Book result2 = bs1.getBookFrom(1);
        // System.out.println(result2.getName());

        // for 루프를 이용해서 책 이름 출력하기
        System.out.println("for 루프 사용");
        for(int i = 0;i < bs1.getLength();i++) {
            System.out.println(bs1.getBookFrom(i).getName());
        }

        // 확장 for 루프를 이용하기
        System.out.println("확장 for 루프 사용");
        for(Book b : bs1) {
            System.out.println(b.getName());
        }

        // iterator 패턴을 이용해서 책 이름 출력하기
        System.out.println("iterator 사용");
        
        // 1: 집합체(책꽂이)로부터 iterator 얻어오기
        // BookShelfIterator iterator = bs1.iterator();
        Iterator<Book> iterator = bs1.iterator();

        // 2: iterator 통해서 원소(책) 얻어오기
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }


        // 문자열 리스트 만들어 출력해보기
        // 자바 컬렉션 : List, Set, Map
        List<String> sList = new ArrayList<String>();
        sList.add("a");
        sList.add("b");
        sList.add("c");

        // 1. for 루프 이용하기
        System.out.println("for 루프 사용");
        for(int i = 0; i < sList.size(); i++) {
            System.out.println(sList.get(i));
        }

        // 2. 확장 for 루프 이용하기
        System.out.println("확장 for 루프 사용");
        for(String s : sList) {
            System.out.println(s);
        }

        // 3. iterator 이용하기
        System.out.println("iterator 사용");

        // 3-1. iterator 얻기
        Iterator<String> sIterator = sList.iterator();

        // 3-2. iterator 이용해서 원소 얻기
        while(sIterator.hasNext()) {
            System.out.println(sIterator.next());
        }

        // 4. 스트림 이용하기
        System.out.println("stream 사용");
        sList.stream().forEach(System.out::println); // forEach 안에 메소드 전달
    }
}
