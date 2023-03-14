package ch01.practice;

import java.util.Iterator;

public class BookShelfIterator implements Iterator<Book> { // 책 꺼내오기
    // 집합체(책꽂이)
    BookShelf bs;
    int index; // 책꽂이에서의 현재 위치
    
    // 생성자
    public BookShelfIterator(BookShelf bs) {
        this.bs = bs; // iterator와 책꽂이가 연결됨
    }

    // 다음 원소가 검사하는 메소드
    @Override
    public boolean hasNext() {
        if(index < bs.getLength()) { // 책이 더 있는 경우
            return true;
        } else {
            return false;
        }
    }

    // 그 다음 원소(책)를 반환하는 메소드
    @Override
    public Book next() {
        Book b = bs.getBookAt(index);
        index++;
        return b;
    }

}    
