package ch01.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch01.practice.BookShelfIterator;

public class BookShelf implements Iterable<Book> { // 책 관리
    private Book[] books; // 배열 선언
    // private List<Book> books = new ArrayList<Book>();
    private int last = 0; // 마지막에 꽂힌 위치

    public BookShelf(int maxsize) {
        // 배열 생성
        this.books = new Book[maxsize];
    }

    // 책 꽂는 메소드
    public void appendBook(Book book){
        books[last] = book;
        last++;
    }

    // 책 가져오는 메소드
    // public Book getBookAt(int index){
    public Book getBookFrom(int index){
        return books[index];
    }

    // 책 갯수를 반환하는 메소드
    public int getLength(){
        return last;
    }

    // 자신의 iterator를 반환하는 메소드
    @Override
    // public BookShelfIterator iterator()
    public Iterator<Book> iterator(){
        return new BookShelfIterator(this); // 현재 내 책꽂이하고 연결
        // return new BookShelfIteratorBackward(this);
    }
}
