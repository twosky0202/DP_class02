package ch11.practice;

public abstract class Entry {
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    // 목록을 표시한다
    public void printList() { // 인자를 받지 않는
        printList("");
    }
    // prefix를 앞에 붙여서 목록을 표시한다 
    protected abstract void printList(String prefix); // string을 받는
    // => 메서드 이름은 같지만 받는 매개변수가 다름 => 메서드 오버로딩

    // 문자열 표시 
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
