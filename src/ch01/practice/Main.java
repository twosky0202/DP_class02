package ch01.practice;

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

        Book result = bs1.getBookAt(0);
        // System.out.println(result.getName());

        Book result2 = bs1.getBookAt(1);
        // System.out.println(result2.getName());

        // for 루프를 이용해서 책 이름 출력하기
        System.out.println("for루프 사용");
        for(int i = 0;i < bs1.getLength();i++) {
            System.out.println(bs1.getBookAt(i).getName());
        }

        // 확장 for문을 이용하기
        System.out.println("확장 for문 사용");
        for(Book b : bs1) {
            System.out.println(b.getName());
        }

        // iterator 패턴을 이용해서 책 이름 출력하기
        System.out.println("iterator 사용");
        
        // 1: 집합체(책꽂이)로부터 iterator 얻어오기
        BookShelfIterator iterator = bs1.iterator();

        // 2: iterator 통해서 원소(책) 얻어오기
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }
}
