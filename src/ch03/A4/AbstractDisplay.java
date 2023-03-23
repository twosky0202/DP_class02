package ch03.A4;

public interface AbstractDisplay {
    public void open();
    public void print();
    public void close();

    public default void display() {
        open();
        for (int i = 0; i < 5; i++) { // 하드 코딩. 함수 안에 있어서 수정하기 힘듦. 유용성 떨어짐
            print();
        }
        close();
    }
}
